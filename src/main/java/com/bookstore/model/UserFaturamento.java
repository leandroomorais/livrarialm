package com.bookstore.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserFaturamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userFaturamentoNome;
	private String userFaturamentoRua;
	private String userFaturamentoCidade;
	private String userFaturamentoStado;
	private String userFaturamentoCep;
	
	@OneToOne(cascade=CascadeType.ALL)
	private UserPagamento userPagamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserFaturamentoNome() {
		return userFaturamentoNome;
	}

	public void setUserFaturamentoNome(String userFaturamentoNome) {
		this.userFaturamentoNome = userFaturamentoNome;
	}

	public String getUserFaturamentoRua() {
		return userFaturamentoRua;
	}

	public void setUserFaturamentoRua(String userFaturamentoRua) {
		this.userFaturamentoRua = userFaturamentoRua;
	}

	public String getUserFaturamentoCidade() {
		return userFaturamentoCidade;
	}

	public void setUserFaturamentoCidade(String userFaturamentoCidade) {
		this.userFaturamentoCidade = userFaturamentoCidade;
	}

	public String getUserFaturamentoStado() {
		return userFaturamentoStado;
	}

	public void setUserFaturamentoStado(String userFaturamentoStado) {
		this.userFaturamentoStado = userFaturamentoStado;
	}

	public String getUserFaturamentoCep() {
		return userFaturamentoCep;
	}

	public void setUserFaturamentoCep(String userFaturamentoCep) {
		this.userFaturamentoCep = userFaturamentoCep;
	}

	public UserPagamento getUserPagamento() {
		return userPagamento;
	}

	public void setUserPagamento(UserPagamento userPagamento) {
		this.userPagamento = userPagamento;
	}
	
	

	
	
	
}
