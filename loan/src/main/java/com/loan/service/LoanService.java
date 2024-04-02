package com.loan.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.loan.dao.LoanDAO;
import com.loan.dto.LoanDTO;
import com.loan.exception.RecordNotFoundException;

@Service
public class LoanService {

	@Autowired
	public LoanDAO repository;

	public ResponseEntity<?> Add(LoanDTO entity) {
		LoanDTO cEntity = null;
		try {

			cEntity = repository.save(entity);

		} catch (Exception e) {

			throw new RecordNotFoundException("Category is already available");
		}
		return new ResponseEntity<>(cEntity, HttpStatus.OK);
	}

	public List<LoanDTO> list() {
		List<LoanDTO> list = null;

		list = repository.findAll();

		return list;
	}
	
	public List<LoanDTO> list(long userId) {
		List<LoanDTO> list = null;

		list = repository.findByUserId(userId);

		return list;
	}

	public LoanDTO update(LoanDTO user) {

		LoanDTO entity = repository.saveAndFlush(user);
		return entity;
	}

	public List<LoanDTO> delete(long id) {
		List<LoanDTO> list = null;
		if (findById(id) != null) {
			repository.deleteById(id);
			list = repository.findAll();
		} else {
			throw new RecordNotFoundException("Not a valid user id");
		}
		return list;
	}

	public LoanDTO findById(long id) {
		try {
			if (id > 0) {
				LoanDTO entity = repository.findById(id);
				if (entity == null) {
					throw new RecordNotFoundException("Record not found");

				} else {
					return entity;
				}
			} else {
				throw new RecordNotFoundException("Not a valid user id");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RecordNotFoundException("Record not found");
		}
	}

	public Blob getTenthMarksheetImageById(long id) throws SerialException, SQLException {
		LoanDTO img = repository.findById(id);
		byte[] blob = img.getTenthMarksheet();
		Blob bBlob = new SerialBlob(blob);
		return bBlob;
	}

	public Blob getTwelfthMarksheetImageById(long id) throws SerialException, SQLException {
		LoanDTO img = repository.findById(id);
		byte[] blob = img.getTwelfthMarksheet();
		Blob bBlob = new SerialBlob(blob);
		return bBlob;
	}

	public Blob getGraduationMarksheetImageById(long id) throws SerialException, SQLException {
		LoanDTO img = repository.findById(id);
		byte[] blob = img.getGraduationMarksheet();
		Blob bBlob = new SerialBlob(blob);
		return bBlob;
	}
}
