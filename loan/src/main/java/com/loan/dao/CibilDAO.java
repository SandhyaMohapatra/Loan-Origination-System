package com.loan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.dto.CibilDTO;

public interface CibilDAO extends JpaRepository<CibilDTO, Long>{
	
	public CibilDTO findById(long id);
	public CibilDTO findByPancard(String pancard);

}
