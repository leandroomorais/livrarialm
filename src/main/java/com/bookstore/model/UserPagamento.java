package com.bookstore.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class UserPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String tipo;
	private String cardNome;
	private String cardNumero;
	private int expiraMes;
	private int expiraAno;
	private int cvc;
	private String titularNome;
	private boolean padraoPagamento;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "userPagamento")
	private UserFaturamento userFaturamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCardNome() {
		return cardNome;
	}

	public void setCardNome(String cardNome) {
		this.cardNome = cardNome;
	}

	public String getCardNumero() {
		return cardNumero;
	}

	public void setCardNumero(String cardNumero) {
		this.cardNumero = cardNumero;
	}

	public int getExpiraMes() {
		return expiraMes;
	}

	public void setExpiraMes(int expiraMes) {
		this.expiraMes = expiraMes;
	}

	public int getExpiraAno() {
		return expiraAno;
	}

	public void setExpiraAno(int expiraAno) {
		this.expiraAno = expiraAno;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public String getTitularNome() {
		return titularNome;
	}

	public void setTitularNome(String titularNome) {
		this.titularNome = titularNome;
	}

	public boolean isPadraoPagamento() {
		return padraoPagamento;
	}

	public void setPadraoPagamento(boolean padraoPagamento) {
		this.padraoPagamento = padraoPagamento;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserFaturamento getUserFaturamento() {
		return userFaturamento;
	}

	public void setUserFaturamento(UserFaturamento userFaturamento) {
		this.userFaturamento = userFaturamento;
	}

	
}
