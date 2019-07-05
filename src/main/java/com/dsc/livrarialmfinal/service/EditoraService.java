package com.dsc.livrarialmfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsc.livrarialmfinal.model.Editora;
import com.dsc.livrarialmfinal.repository.EditoraRepository;


@Service
public class EditoraService {
	
	@Autowired
	private EditoraRepository repository;
	
	public List<Editora> listaAll(){
		return repository.findAll();
	}
	
	public void cadastrar(Editora editora) {
		repository.saveAndFlush(editora);
	}
	
	public Editora  findOne(Long id) {
        return repository.getOne(id);
    }
     
    public void save(Editora editora) {
        repository.saveAndFlush(editora);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
