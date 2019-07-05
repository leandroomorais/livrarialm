package com.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserRemessa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userRemessaNome;
	private String userRemessaRua;
	private String userRemessaCidade;
	private String userRemessaStado;
	private String userRemessaCep;
	private boolean userRemessaPadrao;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserRemessaNome() {
		return userRemessaNome;
	}


	public void setUserRemessaNome(String userRemessaNome) {
		this.userRemessaNome = userRemessaNome;
	}


	public String getUserRemessaRua() {
		return userRemessaRua;
	}


	public void setUserRemessaRua(String userRemessaRua) {
		this.userRemessaRua = userRemessaRua;
	}


	public String getUserRemessaCidade() {
		return userRemessaCidade;
	}


	public void setUserRemessaCidade(String userRemessaCidade) {
		this.userRemessaCidade = userRemessaCidade;
	}


	public String getUserRemessaStado() {
		return userRemessaStado;
	}


	public void setUserRemessaStado(String userRemessaStado) {
		this.userRemessaStado = userRemessaStado;
	}


	public String getUserRemessaCep() {
		return userRemessaCep;
	}


	public void setUserRemessaCep(String userRemessaCep) {
		this.userRemessaCep = userRemessaCep;
	}


	public boolean isUserRemessaPadrao() {
		return userRemessaPadrao;
	}


	public void setUserRemessaPadrao(boolean userRemessaPadrao) {
		this.userRemessaPadrao = userRemessaPadrao;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
}
