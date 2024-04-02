package com.loan.form;

import javax.validation.constraints.NotEmpty;

import com.loan.dto.EmailDetails;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeForm extends BaseForm {

	@NotEmpty(message = "Email is required")
	private String email;
	
	@NotEmpty(message = "Otp is required")
	private Long otp;
	
	
	public EmailDetails getDTO() {
		EmailDetails bean = new EmailDetails();
	     bean.setRecipient(email);
	     bean.setOtp(otp);
		

		return bean;
	}

	public void populate(EmailDetails bean) {
		
		email = bean.getRecipient();
		otp = bean.getOtp();
	}
}
