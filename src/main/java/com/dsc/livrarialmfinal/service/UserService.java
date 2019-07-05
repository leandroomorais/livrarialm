package com.dsc.livrarialmfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsc.livrarialmfinal.model.User;
import com.dsc.livrarialmfinal.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> listaAll(){
		return repository.findAll();
	}
	
	public void cadastrar(User user) {
		repository.saveAndFlush(user);
	}
	
	public void save(User user) {
		repository.saveAndFlush(user);
	}

}
