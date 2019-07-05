package com.dsc.livrarialmfinal.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private BigDecimal totalGeral;
	
	@OneToMany(mappedBy="carrinho", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<ItemCarrinho> itemCarrinhoList;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotalGeral() {
		return totalGeral;
	}

	public void setTotalGeral(BigDecimal totalGeral) {
		this.totalGeral = totalGeral;
	}

	public List<ItemCarrinho> getItemCarrinhoList() {
		return itemCarrinhoList;
	}

	public void setItemCarrinhoList(List<ItemCarrinho> itemCarrinhoList) {
		this.itemCarrinhoList = itemCarrinhoList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
