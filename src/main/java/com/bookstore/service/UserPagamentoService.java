package com.bookstore.service;

import com.bookstore.model.UserPagamento;

public interface UserPagamentoService {
	UserPagamento findById(Long id);
	
	void removeById(Long id);
}
