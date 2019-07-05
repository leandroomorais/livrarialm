package com.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
