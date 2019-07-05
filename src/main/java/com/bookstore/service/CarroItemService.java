package com.bookstore.service;

import java.util.List;

import com.bookstore.model.Livro;
import com.bookstore.model.CarroItem;
import com.bookstore.model.Pedido;
import com.bookstore.model.CarroCompra;
import com.bookstore.model.User;

public interface CarroItemService {
	List<CarroItem> findByCarroCompra(CarroCompra carroCompra);
	
	CarroItem atualizaCarroItem(CarroItem carroItem);
	
	CarroItem addLivroParaCarroItem(Livro livro, User user, int qtd);
	
	CarroItem findById(Long id);
	
	void removeCarroItem(CarroItem carroItem);
	
	CarroItem save(CarroItem carroItem);
	
	List<CarroItem> findByPedido(Pedido pedido);
}
