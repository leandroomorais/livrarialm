package com.dsc.livrarialmfinal.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsc.livrarialmfinal.model.Carrinho;
import com.dsc.livrarialmfinal.model.ItemCarrinho;
import com.dsc.livrarialmfinal.model.ItemPedido;
import com.dsc.livrarialmfinal.model.Livro;
import com.dsc.livrarialmfinal.model.Pedido;
import com.dsc.livrarialmfinal.model.User;
import com.dsc.livrarialmfinal.repository.ItemCarrinhoRepository;
import com.dsc.livrarialmfinal.repository.ItemPedidoRepository;

@Service
public class ItemCarrinhoService {

	@Autowired
	private ItemCarrinhoRepository itemCarrinhoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public List<ItemCarrinho> findByCarrinho(Carrinho carrinho) {
		return itemCarrinhoRepository.findByCarrinho(carrinho);
	}

	public ItemCarrinho updateItemCarrinho(ItemCarrinho itemCarrinho) {
		BigDecimal bigDecimal = new BigDecimal(itemCarrinho.getLivro().getPreco());
		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		itemCarrinho.setSubtotal(bigDecimal);
		itemCarrinhoRepository.save(itemCarrinho);
		return itemCarrinho;
	}

	public ItemCarrinho addLivroToItemCarrinho(Livro livro, User user) {
		List<ItemCarrinho> itemCarrinhoList = findByCarrinho(user.getCarrinho());

		for (ItemCarrinho itemCarrinho : itemCarrinhoList) {
			if (livro.getId() == itemCarrinho.getLivro().getId()) {
				itemCarrinho.setQty(itemCarrinho.getQty());
				itemCarrinho.setSubtotal(new BigDecimal(livro.getPreco()));
				itemCarrinhoRepository.save(itemCarrinho);
				return itemCarrinho;
			}
		}
		
		ItemCarrinho itemCarrinho = new ItemCarrinho();
		itemCarrinho.setCarrinho(user.getCarrinho());
		itemCarrinho.setLivro(livro);
		itemCarrinho.setSubtotal(new BigDecimal(livro.getPreco()));
		itemCarrinho = itemCarrinhoRepository.save(itemCarrinho);
		
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setLivro(livro);
		itemPedido.setItemCarrinho(itemCarrinho);
		itemPedidoRepository.save(itemPedido);
		
		return itemCarrinho;
	}
	
	public void removeItemCarrinho(ItemCarrinho itemCarrinho) {
		itemPedidoRepository.deleteByItemCarrinho(itemCarrinho);
		itemCarrinhoRepository.delete(itemCarrinho);
	}
	
	public ItemCarrinho save(ItemCarrinho itemCarrinho) {
		return itemCarrinhoRepository.save(itemCarrinho);
	}
	
	public List<ItemCarrinho> findByPedido(Pedido pedido){
		return itemCarrinhoRepository.findByPedido(pedido);
	}
}
