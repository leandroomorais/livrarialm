package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.Livro;
import com.bookstore.repository.LivrooRepository;


@Service
public class LivrooService {
	
	@Autowired
	private LivrooRepository  repository;
	
	public List<Livro> listaAll(){
		return repository.findAll();
	}
	
	public void cadastrar(Livro livro) {
		repository.saveAndFlush(livro);
	}
	
	public Livro findOne(Long id) {
		return repository.getOne(id);
	}
	
	public void save(Livro livro) {
		repository.saveAndFlush(livro);
	}
	
	public void delete(Long id) {
		repository.delete(id);
	}

}
