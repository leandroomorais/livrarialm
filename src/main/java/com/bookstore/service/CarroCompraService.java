package com.bookstore.service;

import com.bookstore.model.CarroCompra;

public interface CarroCompraService {
	CarroCompra atualizaCarroCompra(CarroCompra carroCompra);
	
	void limpaCarroCompra(CarroCompra carroCompra);
}
