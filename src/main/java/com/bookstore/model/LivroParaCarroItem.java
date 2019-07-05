package com.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LivroParaCarroItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="livro_id")
	private Livro book;
	
	@ManyToOne
	@JoinColumn(name="carro_item_id")
	private CarroItem carroItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Livro getBook() {
		return book;
	}

	public void setBook(Livro book) {
		this.book = book;
	}

	public CarroItem getCarroItem() {
		return carroItem;
	}

	public void setCarroItem(CarroItem carroItem) {
		this.carroItem = carroItem;
	}
	

}
