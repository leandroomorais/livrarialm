package com.bookstore.service;

import java.util.List;

import com.bookstore.model.Livro;

public interface LivroService {
	List<Livro> findAll ();
	
	Livro findOne(Long id);
	
	List<Livro> findByCategory(String category);
	
	List<Livro> blurrySearch(String title);
}
