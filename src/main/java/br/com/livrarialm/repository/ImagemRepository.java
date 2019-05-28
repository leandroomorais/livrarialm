package br.com.livrarialm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.livrarialm.model.Imagem;

@Repository
public interface ImagemRepository extends PagingAndSortingRepository<Imagem, Long> {
	
	public Imagem findByNome(String nome);

}
