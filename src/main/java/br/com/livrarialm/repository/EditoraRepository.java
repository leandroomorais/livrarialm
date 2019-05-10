package br.com.livrarialm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.livrarialm.model.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

}
