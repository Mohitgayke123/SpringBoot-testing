package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAO;
import com.rays.dto.UserDTO;

@Service
public class UserService {
	
	@Autowired
	public UserDAO dao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		long pk = dao.add(dto);
		return pk;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);
		
	}
	
	public void delete(long id) {
		try {
			UserDTO dto = get(id);
			dao.delete(dto);
		}catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	@Transactional(readOnly = true)
	public UserDTO get(long pk) {
		UserDTO dto = dao.findByPk(pk);
		return dto;
	}

}
