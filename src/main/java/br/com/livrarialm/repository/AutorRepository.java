package br.com.livrarialm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.livrarialm.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {


}
