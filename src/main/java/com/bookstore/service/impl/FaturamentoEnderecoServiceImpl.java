package com.bookstore.service.impl;

import org.springframework.stereotype.Service;

import com.bookstore.model.FaturamentoEndereco;
import com.bookstore.model.UserFaturamento;
import com.bookstore.service.FaturamentoEnderecoService;

@Service
public class FaturamentoEnderecoServiceImpl implements FaturamentoEnderecoService{
	
	public FaturamentoEndereco setByUserFaturamento(UserFaturamento userFaturamento, FaturamentoEndereco faturamentoEndereco) {
		faturamentoEndereco.setFaturamentoEnderecoNome(userFaturamento.getUserFaturamentoNome());
		faturamentoEndereco.setFaturamentoEnderecoRua(userFaturamento.getUserFaturamentoRua());
		faturamentoEndereco.setFaturamentoEnderecoCidade(userFaturamento.getUserFaturamentoCidade());
		faturamentoEndereco.setFaturamentoEnderecoEstado(userFaturamento.getUserFaturamentoStado());
		faturamentoEndereco.setFaturamentoEnderecoCep(userFaturamento.getUserFaturamentoCep());
		
		return faturamentoEndereco;
	}

	

}
