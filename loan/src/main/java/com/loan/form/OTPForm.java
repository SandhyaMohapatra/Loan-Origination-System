package com.loan.form;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OTPForm extends BaseForm {

	@NotEmpty(message = "Otp is required")
	private Long otp;
}
