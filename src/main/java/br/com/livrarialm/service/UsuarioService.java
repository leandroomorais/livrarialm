package br.com.livrarialm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.livrarialm.model.Usuario;
import br.com.livrarialm.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	public List<Usuario> listaAll() {
		return repository.findAll();
	}

	public void cadastrar(Usuario usuario) {
		repository.saveAndFlush(usuario);
	}



	public void save(Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		repository.saveAndFlush(usuario);
	}



}
