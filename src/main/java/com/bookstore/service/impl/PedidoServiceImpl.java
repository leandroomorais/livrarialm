package com.bookstore.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.FaturamentoEndereco;
import com.bookstore.model.Livro;
import com.bookstore.model.CarroItem;
import com.bookstore.model.Pedido;
import com.bookstore.model.Pagamento;
import com.bookstore.model.RemessaEndereco;
import com.bookstore.model.CarroCompra;
import com.bookstore.model.User;
import com.bookstore.repository.PedidoRepository;
import com.bookstore.service.CarroItemService;
import com.bookstore.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CarroItemService carroItemService;
	
	public synchronized Pedido criarPedido(CarroCompra carroCompra,
			RemessaEndereco remessaEndereco,
			FaturamentoEndereco faturamentoEndereco,
			Pagamento pagamento,
			String remessaMetodo,
			User user) {
		Pedido pedido = new Pedido();
		pedido.setFaturamentoEndereco(faturamentoEndereco);
		pedido.setPedidoStatus("feito");
		pedido.setPagamento(pagamento);
		pedido.setRemessaEndereco(remessaEndereco);
		pedido.setRemessaMethod(remessaMetodo);
	
		
		List<CarroItem> carroItemList = carroItemService.findByCarroCompra(carroCompra);
		
		for(CarroItem carroItem : carroItemList) {
			Livro livro = carroItem.getLivro();
			carroItem.setPedido(pedido);
			livro.setInStockNumber(livro.getInStockNumber() - carroItem.getQtd());
		}
		
		pedido.setCarroItemList(carroItemList);
		pedido.setPedidoDate(Calendar.getInstance().getTime());
		pedido.setPedidoTotal(carroCompra.getTotalGeral());
		remessaEndereco.setPedido(pedido);
		pagamento.setPedido(pedido);
		pedido.setUser(user);
		faturamentoEndereco.setPedido(pedido);
		pedido.setUser(user);
		pedido = pedidoRepository.save(pedido);
		
		return pedido;
	}
	
	public Pedido findOne(Long id) {
		return pedidoRepository.findOne(id);
	}


}
