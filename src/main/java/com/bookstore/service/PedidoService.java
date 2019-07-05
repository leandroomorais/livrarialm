package com.bookstore.service;

import com.bookstore.model.FaturamentoEndereco;
import com.bookstore.model.Pedido;
import com.bookstore.model.Pagamento;
import com.bookstore.model.RemessaEndereco;
import com.bookstore.model.CarroCompra;
import com.bookstore.model.User;

public interface PedidoService {
	Pedido criarPedido(CarroCompra carroCompra,
			RemessaEndereco remessaEndereco,
			FaturamentoEndereco faturamentoEndereco,
			Pagamento pagamento,
			String remessaMetodo,
			User user);
	
	Pedido findOne(Long id);
}
