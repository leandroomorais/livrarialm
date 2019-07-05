package com.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.model.Livro;


public interface LivroRepository extends CrudRepository<Livro, Long>{
	
}
