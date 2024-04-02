package com.loan.dto;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="loan")
@Getter
@Setter
public class LoanDTO extends BaseDTO {
	
	@Column(name = "userId")
	private Long userId;
	
	@Column(name = "firstName", length = 755)
	private String firstName;

	@Column(name = "lastName", length = 755)
	private String lastName;
	
	@Column(name = "address", length = 755)
	private String address;

	@Column(name = "pancard", length = 755)
	private String pancard;
	
	@Column(name = "adharcard", length = 755)
	private String adharcard;
	
	@Column(name = "bplcard", length = 755)
	private String bplcard;
	
	@Column(name = "parentName", length = 755)
	private String parentName;
	
	@Column(name = "parentOccupation", length = 755)
	private String parentOccupation;
	
	@Column(name = "parentIncome", length = 755)
	private String parentIncome;
	
	@Column(name = "loanAmount")
	private Long loanAmount;
	
	@Column(name = "loanAccNum")
	private Long loanAccNum;
	
	@Column(name = "collegeName", length = 755)
	private String collegeName;
	
	@Column(name = "branchName", length = 755)
	private String branchName;
	
	@Column(name = "graduationPercentage", length = 755)
	private String graduationPercentage;
	
	@Column(name = "cgpa", length = 755)
	private String cgpa;
	
	@Column(name = "dropYears", length = 755)
	private String dropYears;
	
	
	@Column(name = "bankName", length = 755)
	private String bankName;
	
	@Column(name = "accountNumber", length = 755)
	private String accountNumber;
	
	@Column(name = "ifscCode", length = 755)
	private String ifscCode;
	
	
	@Column(name = "tenthMarksheet", columnDefinition = "LONGBLOB")
	 private byte[] tenthMarksheet;

	@Column(name = "twelfthMarksheet", columnDefinition = "LONGBLOB")
	 private byte[] twelfthMarksheet;

	
	@Column(name = "graduationMarksheet", columnDefinition = "LONGBLOB")
	 private byte[] graduationMarksheet;

	@Column(name = "status", length = 755)
	private String status;
	
	@Column(name = "officerStatus", length = 755)
	private String officerStatus;
	
	@Column(name = "roi", length = 755)
	private String roi;

	@Override
	public String toString() {
		return "LoanDTO [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", pancard="
				+ pancard + ", adharcard=" + adharcard + ", bplcard=" + bplcard + ", parentName=" + parentName
				+ ", parentOccupation=" + parentOccupation + ", parentIncome=" + parentIncome + ", loanAmount="
				+ loanAmount + ", collegeName=" + collegeName + ", branchName=" + branchName + ", graduationPercentage="
				+ graduationPercentage + ", cgpa=" + cgpa + ", dropYears=" + dropYears + ", bankName=" + bankName
				+ ", accountNumber=" + accountNumber + ", ifscCode=" + ifscCode + ", tenthMarksheet="
				+ Arrays.toString(tenthMarksheet) + ", twelfthMarksheet=" + Arrays.toString(twelfthMarksheet)
				+ ", graduationMarksheet=" + Arrays.toString(graduationMarksheet) + "]";
	}

	
	
	
	
	

}
