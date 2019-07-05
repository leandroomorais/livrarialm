package com.bookstore.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.CarroItem;
import com.bookstore.model.CarroCompra;
import com.bookstore.repository.CarroCompraRepository;
import com.bookstore.service.CarroItemService;
import com.bookstore.service.CarroCompraService;

@Service
public class CarroCompraServiceImpl implements CarroCompraService{
	
	@Autowired
	private CarroItemService carroItemService;
	
	@Autowired
	private CarroCompraRepository carroCompraRepository;
	
	public CarroCompra atualizaCarroCompra(CarroCompra carroCompra) {
		BigDecimal carroTotal = new BigDecimal(0);
		
		List<CarroItem> carroItemList = carroItemService.findByCarroCompra(carroCompra);
		
		for (CarroItem carroItem : carroItemList) {
			if(carroItem.getLivro().getInStockNumber() > 0) {
				carroItemService.atualizaCarroItem(carroItem);
				carroTotal = carroTotal.add(carroItem.getSubtotal());
			}
		}
		
		carroCompra.setTotalGeral(carroTotal);
		
		carroCompraRepository.save(carroCompra);
		
		return carroCompra;
	}
	
	public void limpaCarroCompra(CarroCompra carroCompra) {
		List<CarroItem> carroItemList = carroItemService.findByCarroCompra(carroCompra);
		
		for (CarroItem carroItem : carroItemList) {
			carroItem.setCarroCompra(null);;
			carroItemService.save(carroItem);
		}
		
		carroCompra.setTotalGeral(new BigDecimal(0));
		
		carroCompraRepository.save(carroCompra);
	}

}
