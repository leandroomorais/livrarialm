package com.bookstore.model;

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
public class CarroCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private BigDecimal TotalGeral;
	
	@OneToMany(mappedBy="carroCompra", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<CarroItem> carroItems;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotalGeral() {
		return TotalGeral;
	}

	public void setTotalGeral(BigDecimal totalGeral) {
		TotalGeral = totalGeral;
	}

	public List<CarroItem> getCarroItems() {
		return carroItems;
	}

	public void setCarroItems(List<CarroItem> carroItems) {
		this.carroItems = carroItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
