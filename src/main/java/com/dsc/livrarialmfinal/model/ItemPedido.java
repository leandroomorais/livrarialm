package com.dsc.livrarialmfinal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class ItemPedido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "livro_id")
	private Livro livro;
	
	@ManyToOne
	@JoinColumn(name = "item_carrinho_id")
	private ItemCarrinho itemCarrinho;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public ItemCarrinho getItemCarrinho() {
		return itemCarrinho;
	}

	public void setItemCarrinho(ItemCarrinho itemCarrinho) {
		this.itemCarrinho = itemCarrinho;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
