package com.loan.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "otpemail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails extends BaseDTO{
	
	 // Class data members
	@Column(name = "recipient")
    private String recipient;
	
	@Column(name = "msgBody")
    private String msgBody;
	
	@Column(name = "subject")
    private String subject;
	
	@Column(name = "otp")
    private Long otp;
	
	@Column(name = "attachment")
    private String attachment;

	@Override
	public String toString() {
		return "EmailDetails [recipient=" + recipient + ", msgBody=" + msgBody + ", subject=" + subject + ", otp=" + otp
				+ ", attachment=" + attachment + "]";
	}

	
	
	

}
