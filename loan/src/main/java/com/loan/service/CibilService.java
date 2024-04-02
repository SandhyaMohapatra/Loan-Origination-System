package com.loan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.loan.dao.CibilDAO;
import com.loan.dto.CibilDTO;
import com.loan.exception.RecordNotFoundException;

@Service
public class CibilService {

	@Autowired
	public CibilDAO repository;

	public CibilDTO Add(CibilDTO entity) {
		CibilDTO cEntity = null;
		try {
			cEntity = repository.findByPancard(entity.getPancard());
			if(cEntity == null) {
				cEntity = repository.save(entity);
			}else {
				return cEntity;
			}

		} catch (Exception e) {

			throw new RecordNotFoundException("Somthing went wrong");
		}
		return cEntity;
	}
}
