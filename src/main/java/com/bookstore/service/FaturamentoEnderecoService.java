package com.bookstore.service;

import com.bookstore.model.FaturamentoEndereco;
import com.bookstore.model.UserFaturamento;

public interface FaturamentoEnderecoService {
	FaturamentoEndereco setByUserFaturamento(UserFaturamento userFaturamento, FaturamentoEndereco faturamentoEndereco);
}
