package br.com.livrarialm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livrarialm.model.Livro;
import br.com.livrarialm.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
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
		repository.deleteById(id);
	}

}
