package com.dsc.livrarialmfinal.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsc.livrarialmfinal.model.Carrinho;
import com.dsc.livrarialmfinal.model.ItemCarrinho;
import com.dsc.livrarialmfinal.repository.CarrinhoRepository;

@Service
public class CarrinhoService {
	
	@Autowired
	private ItemCarrinhoService itemCarrinhoService;
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	public Carrinho updateCarrinho(Carrinho carrinho) {
		BigDecimal carroTotal = new BigDecimal(0);
		
		List<ItemCarrinho> itemCarrinhoList = itemCarrinhoService.findByCarrinho(carrinho);
		
		for(ItemCarrinho itemCarrinho: itemCarrinhoList) {
			itemCarrinhoService.updateItemCarrinho(itemCarrinho);
			carroTotal = carroTotal.add(itemCarrinho.getSubtotal());
		}
		
		carrinho.setTotalGeral(carroTotal);
		
		carrinhoRepository.save(carrinho);
		
		return carrinho;
	}
	
	

}
