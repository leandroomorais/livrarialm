package com.dsc.livrarialmfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dsc.livrarialmfinal.model.ItemCarrinho;
import com.dsc.livrarialmfinal.model.ItemPedido;

@Transactional
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{
	void deleteByItemCarrinho(ItemCarrinho itemCarrinho);

}
