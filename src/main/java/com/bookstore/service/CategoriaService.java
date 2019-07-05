package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.Categoria;
import com.bookstore.repository.CategoriaRepository;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> listaAll(){
		return repository.findAll();
	}
	
	public void cadastrar(Categoria cat) {
		repository.saveAndFlush(cat);
	}
	
	public Categoria  findOne(Long id) {
        return repository.getOne(id);
    }
     
    public void save(Categoria cat) {
        repository.saveAndFlush(cat);
    }
     
    public void delete(Long id) {
        repository.delete(id);
    }

}
