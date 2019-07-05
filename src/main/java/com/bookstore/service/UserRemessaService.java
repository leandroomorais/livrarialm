package com.bookstore.service;

import com.bookstore.model.UserRemessa;

public interface UserRemessaService {
	UserRemessa findById(Long id);
	
	void removeById(Long id);
}
