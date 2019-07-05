package com.dsc.livrarialmfinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsc.livrarialmfinal.model.Carrinho;
import com.dsc.livrarialmfinal.model.ItemCarrinho;
import com.dsc.livrarialmfinal.model.Pedido;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {
	
	List<ItemCarrinho> findByCarrinho(Carrinho carrinho);
	
	List<ItemCarrinho> findByPedido(Pedido pedido);
		
}
