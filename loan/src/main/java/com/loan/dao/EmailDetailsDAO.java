package com.loan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.dto.EmailDetails;

public interface EmailDetailsDAO extends JpaRepository<EmailDetails, Long> {
	
	public EmailDetails findByRecipient(String email);
	public EmailDetails findTopByOrderByIdDesc();

}
