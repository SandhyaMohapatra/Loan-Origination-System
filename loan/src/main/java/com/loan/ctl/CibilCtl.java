package com.loan.ctl;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.loan.dto.CibilDTO;
import com.loan.dto.LoanDTO;
import com.loan.dto.UserDTO;
import com.loan.exception.RecordNotFoundException;
import com.loan.form.CibilForm;
import com.loan.form.LoanForm;
import com.loan.service.CibilService;
import com.loan.service.LoanService;
import com.loan.utility.DataUtility;

@Controller
public class CibilCtl {
	
	@Autowired
	public CibilService service;
	
	@GetMapping("/cibil")
	public String loan(@ModelAttribute("form")CibilForm form, Model model, HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("user");
		if(user == null) {
			return "login";
		}else {
			model.addAttribute("score", 0);
			return "cibil";	
		}
		
	}

	@PostMapping("/getCibil")
	public String Add(@Valid @ModelAttribute("form")CibilForm form,  BindingResult bindingResult, Model model, HttpSession session) throws IOException {
		UserDTO user = (UserDTO) session.getAttribute("user");
		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "loan";
		}else {
			CibilDTO dto = form.getDTO();
			dto.setScore(DataUtility.getRandomCibil());
			CibilDTO cDto = service.Add(dto);
			model.addAttribute("score", cDto.getScore());
			return "cibil";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "cibil";
		}
	}

}
