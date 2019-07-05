package com.dsc.livrarialmfinal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsc.livrarialmfinal.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	
}
