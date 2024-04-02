package com.loan.form;

import javax.validation.constraints.NotEmpty;

import com.loan.dto.CibilDTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CibilForm extends BaseForm{
	
	@NotEmpty(message = "This is required")
	private String pancard;
	
	
	public CibilDTO getDTO() {
		CibilDTO bean = new CibilDTO();
	     bean.setPancard(pancard);
		return bean;
	}

	public void populate(CibilDTO bean) {
		pancard = bean.getPancard();
	}

}
