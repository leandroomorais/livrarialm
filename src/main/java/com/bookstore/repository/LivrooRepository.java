package com.bookstore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Livro;

@Repository
public interface LivrooRepository extends JpaRepository<Livro, Long> {

	
}
