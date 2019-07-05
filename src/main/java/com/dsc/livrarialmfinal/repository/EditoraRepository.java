package com.dsc.livrarialmfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsc.livrarialmfinal.model.Editora;


@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

}
