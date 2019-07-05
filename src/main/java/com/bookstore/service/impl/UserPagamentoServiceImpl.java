package com.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.UserPagamento;
import com.bookstore.repository.UserPagamentoRepository;
import com.bookstore.service.UserPagamentoService;

@Service
public class UserPagamentoServiceImpl implements UserPagamentoService{

	@Autowired
	private UserPagamentoRepository userPagamentoRepository;
		
	public UserPagamento findById(Long id) {
		return userPagamentoRepository.findOne(id);
	}
	
	public void removeById(Long id) {
		userPagamentoRepository.delete(id);
	}
} 
