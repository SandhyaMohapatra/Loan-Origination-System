package com.loan.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cibil")
@Getter
@Setter
public class CibilDTO extends BaseDTO{
	
	@Column(name = "score")
	private Long score;
	
	@Column(name = "pancard", length = 755)
	private String pancard;

}
