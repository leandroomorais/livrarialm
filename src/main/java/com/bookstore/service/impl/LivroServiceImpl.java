package com.bookstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.Livro;
import com.bookstore.repository.LivroRepository;
import com.bookstore.service.LivroService;

@Service
public class LivroServiceImpl implements LivroService{
	@Autowired
	private LivroRepository livroRepository;
	
	public List<Livro> findAll() {
		List<Livro> livroList = (List<Livro>) livroRepository.findAll();
		List<Livro> livrosAtivosList = new ArrayList<>();
		
		for (Livro livro: livroList) {
			if(livro.isActive()) {
				livrosAtivosList.add(livro);
			}
		}
		
		return livrosAtivosList;
	}
	
	public Livro findOne(Long id) {
		return livroRepository.findOne(id);
	}

	@Override
	public List<Livro> findByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livro> blurrySearch(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
