package com.bookstore.service.impl;

import org.springframework.stereotype.Service;

import com.bookstore.model.Pagamento;
import com.bookstore.model.UserPagamento;
import com.bookstore.service.PagamentoService;

@Service
public class PagamentoServiceImpl implements PagamentoService{
	
	public Pagamento setByUserPagamento(UserPagamento userPagamento, Pagamento pagamento) {
		pagamento.setTipo(userPagamento.getTipo());
		pagamento.setCardNome(userPagamento.getCardNome());
		pagamento.setCardNumero(userPagamento.getCardNumero());
		pagamento.setExpiraAno(userPagamento.getExpiraAno());
		pagamento.setExpiraMes(userPagamento.getExpiraMes());
		pagamento.setCvc(userPagamento.getCvc());
		
		return pagamento;
	}



}
