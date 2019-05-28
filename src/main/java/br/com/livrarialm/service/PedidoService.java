package br.com.livrarialm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livrarialm.model.Pedido;
import br.com.livrarialm.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> listaAll(){
		return repository.findAll();
	}
	
	public void cadastrar(Pedido pedido) {
		repository.saveAndFlush(pedido);
	}
	
	public Pedido findOne(Long id) {
		return repository.getOne(id);
	}
	
	public void save(Pedido pedido) {
		repository.saveAndFlush(pedido);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}


}
