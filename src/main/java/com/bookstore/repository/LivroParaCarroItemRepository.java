package com.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.model.LivroParaCarroItem;
import com.bookstore.model.CarroItem;

@Transactional
public interface LivroParaCarroItemRepository extends CrudRepository<LivroParaCarroItem, Long> {
	void deleteByCarroItem(CarroItem carroItem);
}
