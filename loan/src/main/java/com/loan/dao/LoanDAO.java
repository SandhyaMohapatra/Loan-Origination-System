package com.loan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.dto.LoanDTO;


public interface LoanDAO extends JpaRepository<LoanDTO, Long> {
	
	public LoanDTO findById(long id);
	public List<LoanDTO> findByUserId(long id);

}
