package br.com.livrarialm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livrarialm.model.Autor;
import br.com.livrarialm.repository.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository repository;
	
	public List<Autor> listaAll(){
		return repository.findAll();
	}
	
	public void cadastrar(Autor autor) {
		repository.saveAndFlush(autor);
	}
	
	public Autor findOne(Long id) {
		return repository.getOne(id);
	}
	
	public void save(Autor autor) {
		repository.saveAndFlush(autor);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	

}
