package com.bookstore.service;

import com.bookstore.model.RemessaEndereco;
import com.bookstore.model.UserRemessa;

public interface RemessaEnderecoService {
	RemessaEndereco setByUserRemessa(UserRemessa userRemessa, RemessaEndereco remessaEndereco);
}
