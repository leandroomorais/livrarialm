package com.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class RemessaEndereco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String RemessaEnderecoNome;
	private String RemessaEnderecoRua;
	private String RemessaEnderecoCidade;
	private String RemessaEnderecoEstado;
	private String RemessaEnderecoCep;
	
	
	@OneToOne
	private Pedido pedido;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRemessaEnderecoNome() {
		return RemessaEnderecoNome;
	}


	public void setRemessaEnderecoNome(String remessaEnderecoNome) {
		RemessaEnderecoNome = remessaEnderecoNome;
	}


	public String getRemessaEnderecoRua() {
		return RemessaEnderecoRua;
	}


	public void setRemessaEnderecoRua(String remessaEnderecoRua) {
		RemessaEnderecoRua = remessaEnderecoRua;
	}


	public String getRemessaEnderecoCidade() {
		return RemessaEnderecoCidade;
	}


	public void setRemessaEnderecoCidade(String remessaEnderecoCidade) {
		RemessaEnderecoCidade = remessaEnderecoCidade;
	}


	public String getRemessaEnderecoEstado() {
		return RemessaEnderecoEstado;
	}


	public void setRemessaEnderecoEstado(String remessaEnderecoEstado) {
		RemessaEnderecoEstado = remessaEnderecoEstado;
	}


	public String getRemessaEnderecoCep() {
		return RemessaEnderecoCep;
	}


	public void setRemessaEnderecoCep(String remessaEnderecoCep) {
		RemessaEnderecoCep = remessaEnderecoCep;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
