package br.com.livrarialm.config;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.livrarialm.model.Usuario;
import br.com.livrarialm.repository.UsuarioRepository;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}

}
