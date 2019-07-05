package com.bookstore.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.Livro;
import com.bookstore.model.LivroParaCarroItem;
import com.bookstore.model.CarroItem;
import com.bookstore.model.Pedido;
import com.bookstore.model.CarroCompra;
import com.bookstore.model.User;
import com.bookstore.repository.LivroParaCarroItemRepository;
import com.bookstore.repository.CarroItemRepository;
import com.bookstore.service.CarroItemService;

@Service
public class CartItemServiceImpl implements CarroItemService{
	
	@Autowired
	private CarroItemRepository carroItemRepository;
	
	@Autowired
	private LivroParaCarroItemRepository livroParaCarroItemRepository;
	
	public List<CarroItem> findByCarroCompra(CarroCompra carroCompra) {
		return carroItemRepository.findByCarroCompra(carroCompra);
	}
	
	public CarroItem atualizaCarroItem(CarroItem carroItem) {
		BigDecimal bigDecimal = new BigDecimal(carroItem.getLivro().getPreco()).multiply(new BigDecimal(carroItem.getQtd()));
		
		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		carroItem.setSubtotal(bigDecimal);
		
		carroItemRepository.save(carroItem);
		
		return carroItem;
	}
	
	public CarroItem addLivroParaCarroItem(Livro livro, User user, int qtd) {
		List<CarroItem> carroItemList = findByCarroCompra(user.getCarroCompra());
		
		for (CarroItem carroItem : carroItemList) {
			if(livro.getId() == carroItem.getLivro().getId()) {
				carroItem.setQtd(carroItem.getQtd()+qtd);
				carroItem.setSubtotal(new BigDecimal(livro.getPreco()).multiply(new BigDecimal(qtd)));
				carroItemRepository.save(carroItem);
				return carroItem;
			}
		}
		
		CarroItem carroItem = new CarroItem();
		carroItem.setCarroCompra(user.getCarroCompra());
		carroItem.setLivro(livro);
		
		carroItem.setQtd(qtd);
		carroItem.setSubtotal(new BigDecimal(livro.getPreco()).multiply(new BigDecimal(qtd)));
		carroItem = carroItemRepository.save(carroItem);
		
		LivroParaCarroItem livroParaCarroItem = new LivroParaCarroItem();
		livroParaCarroItem.setBook(livro);
		livroParaCarroItem.setCarroItem(carroItem);
		livroParaCarroItemRepository.save(livroParaCarroItem);
		
		return carroItem;
	}
	
	public CarroItem findById(Long id) {
		return carroItemRepository.findOne(id);
	}
	
	public void removeCarroItem(CarroItem carroItem) {
		livroParaCarroItemRepository.deleteByCarroItem(carroItem);
		carroItemRepository.delete(carroItem);
	}
	
	public CarroItem save(CarroItem carroItem) {
		return carroItemRepository.save(carroItem);
	}

	public List<CarroItem> findByPedido(Pedido pedido) {
		return carroItemRepository.findByPedido(pedido);
	}


}
