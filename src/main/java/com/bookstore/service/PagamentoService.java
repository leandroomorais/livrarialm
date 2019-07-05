package com.bookstore.service;

import com.bookstore.model.Pagamento;
import com.bookstore.model.UserPagamento;

public interface PagamentoService {
	Pagamento setByUserPagamento(UserPagamento userPagamento, Pagamento pagamento);
}
