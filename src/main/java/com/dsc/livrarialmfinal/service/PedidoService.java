package com.dsc.livrarialmfinal.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsc.livrarialmfinal.model.Carrinho;
import com.dsc.livrarialmfinal.model.ItemCarrinho;
import com.dsc.livrarialmfinal.model.Livro;
import com.dsc.livrarialmfinal.model.Pedido;
import com.dsc.livrarialmfinal.model.User;
import com.dsc.livrarialmfinal.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemCarrinhoService itemCarrinhoService;
	
	public synchronized Pedido criarPedido(Carrinho carrinho, String metodoPagamento, User user) {
		Pedido pedido = new Pedido();
		pedido.setStatusPedido("criado");
		pedido.setFormaPagamento(metodoPagamento);
		
		List<ItemCarrinho> itemCarrinhoList = itemCarrinhoService.findByCarrinho(carrinho);
		
		for(ItemCarrinho itemCarrinho : itemCarrinhoList) {
			Livro livro = itemCarrinho.getLivro();
			itemCarrinho.setPedido(pedido);
		}
		
		pedido.setItemCarrinhoList(itemCarrinhoList);
		pedido.setDataPedido(Calendar.getInstance().getTime());
		pedido.setValorTotal(carrinho.getTotalGeral());
		pedido.setUser(user);
		
		pedido = pedidoRepository.save(pedido);
		
		return pedido;
	}

}
