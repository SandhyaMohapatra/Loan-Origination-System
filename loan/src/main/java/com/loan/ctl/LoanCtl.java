package com.loan.ctl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.loan.dto.LoanDTO;
import com.loan.dto.UserDTO;
import com.loan.exception.RecordNotFoundException;
import com.loan.form.LoanForm;
import com.loan.service.LoanService;
import com.loan.utility.DataUtility;



@Controller
public class LoanCtl {
	
	
	@Autowired
	public LoanService service;
	
	@GetMapping("/loan")
	public String loan(@ModelAttribute("form")LoanForm form, Model model, HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("user");
		if(user == null) {
			return "login";
		}else {
			return "loan";	
		}
		
	}

	@PostMapping("/applyLoan")
	public String Add(@RequestParam(value = "tenthMarksheetImage") MultipartFile tenthMarksheetImage,
			@RequestParam(value = "graduationMarksheetImage") MultipartFile graduationMarksheetImage,
			@RequestParam(value = "twelfthMarksheetImage") MultipartFile twelfthMarksheetImage,
			@Valid @ModelAttribute("form")LoanForm form,  BindingResult bindingResult, Model model, HttpSession session) throws IOException {
		UserDTO user = (UserDTO) session.getAttribute("user");
		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "loan";
		}else {
			LoanDTO bean = form.getDTO();			
			bean.setTenthMarksheet(tenthMarksheetImage.getBytes());
			bean.setTwelfthMarksheet(twelfthMarksheetImage.getBytes());
			bean.setGraduationMarksheet(graduationMarksheetImage.getBytes());
			bean.setUserId(user.getId());
			bean.setStatus("Applied");
			bean.setOfficerStatus("Under Review");
			bean.setLoanAccNum(DataUtility.getRandomLoanAccNumber());
			System.out.println("bean.getDropYears(): "+bean.getDropYears().length()+ "bean.getCgpa()" +bean.getCgpa()+ "bean.getGraduationPercentage(): "+bean.getGraduationPercentage());
			if(bean.getDropYears().length()==0 && DataUtility.getLong(bean.getCgpa())>8 && DataUtility.getLong(bean.getGraduationPercentage())>80) {
				bean.setRoi("7.5");
			}else {
				bean.setRoi("9");
			}
			if(form.getId()>0) {
				service.update(bean);
				model.addAttribute("success", "Loan Updated successfully");
			}else {
			service.Add(bean);
			model.addAttribute("success", "Loan application apply successfully, Please wait for approvals");
			}
			
			return "loan";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "loan";
		}
	}
	
	@GetMapping("/loanList")
	public String list(@ModelAttribute("form")LoanForm form, Model model, HttpSession session){
	
		UserDTO user = (UserDTO) session.getAttribute("user");
		if(user == null) {
			return "login";
		}else {
			
		
		List<LoanDTO> list = null;
		if(user.getUserRole().equals("Admin") || user.getUserRole().equals("Officer") ) {
			System.out.println("AS an Admin..");
			 list = service.list();
		}else {
			list = service.list(user.getId());
		}
	    model.addAttribute("list", list);
	    return "loanlist";
		}
	    
		
	}
	
	@GetMapping("/loanDetails")
	public String loanDetails(@ModelAttribute("form")LoanForm form, Model model, @RequestParam("id") long id){
	LoanDTO loan = service.findById(id);
	model.addAttribute("loan", loan);
	return "loandetails";
		
	}
	
	
	
	
	@GetMapping("/loanEdit")	
	public String update(@ModelAttribute("form")LoanForm form, Model model, @RequestParam("id") long id ){
		LoanDTO bean = service.findById(id);
		form.populate(bean);
		model.addAttribute("bean",bean);	
		return "loan";
	}
	
	@GetMapping("/loanDelete")	
	public String delete(@ModelAttribute("form")LoanForm form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);	
		
		List<LoanDTO> list = service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "Loan Deleted successfully");
		return "loanlist";
	}
	
	@GetMapping("/approveLoan")	
	public String approveLoan(@ModelAttribute("form")LoanForm form, Model model, @RequestParam("id") long id ) throws Exception{
		LoanDTO lDto = service.findById(id);
		lDto.setStatus("Approved");
	    service.update(lDto);
		return "redirect:/loanDetails?id="+id;
	}
	
	@GetMapping("/rejectLoan")	
	public String rejectLoan(@ModelAttribute("form")LoanForm form, Model model, @RequestParam("id") long id ) throws Exception{
		LoanDTO lDto = service.findById(id);
		lDto.setStatus("Rejected");
	    service.update(lDto);
		return "redirect:/loanDetails?id="+id;
	}

	@GetMapping("/approveLoanByOfficer")	
	public String approveLoanByOfficer(@ModelAttribute("form")LoanForm form, Model model, @RequestParam("id") long id ) throws Exception{
		LoanDTO lDto = service.findById(id);
		lDto.setOfficerStatus("Approved");
	    service.update(lDto);
		return "redirect:/loanDetails?id="+id;
	}
	
	@GetMapping("/rejectLoanByOfficer")	
	public String rejectLoanByOfficer(@ModelAttribute("form")LoanForm form, Model model, @RequestParam("id") long id ) throws Exception{
		LoanDTO lDto = service.findById(id);
		lDto.setOfficerStatus("Rejected");
	    service.update(lDto);
		return "redirect:/loanDetails?id="+id;
	}
	
	
	@GetMapping("/getTenthMarksheetImage/{id}")
	public void getTenthMarksheetImage(HttpServletResponse response, @PathVariable("id") long id) throws Exception {
		response.setContentType("image/jpeg");		
		Blob blb=service.getTenthMarksheetImageById(id);				
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	
	}
	
	@GetMapping("/getTwelfthMarksheetImage/{id}")
	public void getTwelfthMarksheetImage(HttpServletResponse response, @PathVariable("id") long id) throws Exception {
		response.setContentType("image/jpeg");		
		Blob blb=service.getTwelfthMarksheetImageById(id);				
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	
	}
	
	@GetMapping("/getGraduationMarksheetImage/{id}")
	public void getNewsImage(HttpServletResponse response, @PathVariable("id") long id) throws Exception {
		response.setContentType("image/jpeg");		
		Blob blb=service.getGraduationMarksheetImageById(id);				
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	
	}

}
