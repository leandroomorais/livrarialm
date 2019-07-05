package com.bookstore.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CarroItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int qtd;
	private BigDecimal subtotal;
	
	@OneToOne
	private Livro livro;
	
	@OneToMany(mappedBy = "carroItem")
	@JsonIgnore
	private List<LivroParaCarroItem> bookToCartItemList;
	
	@ManyToOne
	@JoinColumn(name="carro_compra_id")
	private CarroCompra carroCompra;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Pedido pedido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<LivroParaCarroItem> getBookToCartItemList() {
		return bookToCartItemList;
	}

	public void setBookToCartItemList(List<LivroParaCarroItem> bookToCartItemList) {
		this.bookToCartItemList = bookToCartItemList;
	}

	public CarroCompra getCarroCompra() {
		return carroCompra;
	}

	public void setCarroCompra(CarroCompra carroCompra) {
		this.carroCompra = carroCompra;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
}
