package com.loan.ctl;

import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.loan.dto.EmailDetails;
import com.loan.form.HomeForm;
import com.loan.form.UserForm;
import com.loan.service.EmailService;
import com.loan.service.EmailServiceImpl;
import com.loan.utility.DataUtility;

@Controller
public class HomeCtl {
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private EmailServiceImpl service;
	
	@GetMapping("/")
	public String homePage(@ModelAttribute("form") HomeForm form) {

		return "home";
	}

	@PostMapping("/GetOtp")
	public String home(@ModelAttribute("form") HomeForm form, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				System.out.println("bindingResult : " + bindingResult);
				return "home";
			} else {
				EmailDetails details = form.getDTO();
				Long optNum = DataUtility.getRandom();
				details.setMsgBody("Your OTP is: "+optNum);
				details.setSubject("Verify Email By Below OTP");
				details.setOtp(optNum);
			String status =	emailService.sendSimpleMail(details);
				if(status.equals("Email is already registered")) {
					model.addAttribute("error", "Email is already registered");
				}else {
					model.addAttribute("success", "OTP is Sent");
					
					return "otpview";
				}
				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "home";
		  }
		
		return "home";
	}
	
	@PostMapping("/otp")
	public String verifyOtp(@ModelAttribute("form") HomeForm form, BindingResult bindingResult, Model model) {
		try {
		
		if (bindingResult.hasErrors()) {
			System.out.println("Somthing went wrong");
			System.out.println("bindingResult : " + bindingResult);
			
			return "otpview";
		} else {
			EmailDetails eDto = form.getDTO();
			EmailDetails eDto1 = service.findLastOTP();
			System.out.println("OTP from Forms: "+eDto.getOtp());
			System.out.println("OTP from Database: "+eDto1.getOtp());
            if(eDto.getOtp().equals(eDto1.getOtp())) {
            	model.addAttribute("Success", "OTP is vierfied: "+eDto.getOtp());
            	System.out.println("eDto.getRecipient() email: "+eDto1.getRecipient());
    			return "redirect:/registration?email="+eDto1.getRecipient();
            }else {
            	model.addAttribute("error", "Invalid OTP");
            	return "otpview";
            }
			
	
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "otpview";
		  }
		
	}

}
