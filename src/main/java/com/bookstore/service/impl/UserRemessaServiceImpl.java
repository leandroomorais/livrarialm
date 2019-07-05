package com.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.UserRemessa;
import com.bookstore.repository.UserRemessaRepository;
import com.bookstore.service.UserRemessaService;

@Service
public class UserRemessaServiceImpl implements UserRemessaService{
	
	@Autowired
	private UserRemessaRepository userRemessaRepository;
	
	
	public UserRemessa findById(Long id) {
		return userRemessaRepository.findOne(id);
	}
	
	public void removeById(Long id) {
		userRemessaRepository.delete(id);
	}

}
