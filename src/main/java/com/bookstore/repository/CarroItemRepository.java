package com.bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.model.CarroItem;
import com.bookstore.model.Pedido;
import com.bookstore.model.CarroCompra;

@Transactional
public interface CarroItemRepository extends CrudRepository<CarroItem, Long>{
	List<CarroItem> findByCarroCompra(CarroCompra carroCompra);
	
	List<CarroItem> findByPedido(Pedido pedido);
}
