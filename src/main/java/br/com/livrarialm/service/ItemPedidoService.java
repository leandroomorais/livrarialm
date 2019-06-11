package br.com.livrarialm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import br.com.livrarialm.model.ItemPedido;
import br.com.livrarialm.model.Livro;
import br.com.livrarialm.repository.ItemPedidoRepository;
import br.com.livrarialm.repository.LivroRepository;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository repository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	private Map<Livro, Integer> livros = new HashMap<>();
	
	public List<ItemPedido> listaAll(){
		return repository.findAll();
	}
	
	public void cadastrar(ItemPedido itemPedido) {
		repository.saveAndFlush(itemPedido);
	}
	
	public ItemPedido findOne(Long id) {
		return repository.getOne(id);
	}
	
	public void save(ItemPedido itemPedido) {
		repository.saveAndFlush(itemPedido);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void addLivro(Livro livro) {
		if(livros.containsKey(livro)) {
			livros.replace(livro, livros.get(livro) + 1);
		}else {
			livros.put(livro, 1);
		}
	}
	
	public void removeLivro(Livro livro) {
		if(livros.containsKey(livro)) {
			if(livros.get(livro) > 1)
				livros.replace(livro, livros.get(livro) - 1);
			else if(livros.get(livro) == 1) {
				livros.remove(livro);
			}
		}
	}
	
	
	
	
	
}
