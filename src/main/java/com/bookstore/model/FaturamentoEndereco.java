package com.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FaturamentoEndereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String FaturamentoEnderecoNome;
	private String FaturamentoEnderecoRua;
	private String FaturamentoEnderecoCidade;
	private String FaturamentoEnderecoEstado;
	private String FaturamentoEnderecoCep;
	
	@OneToOne
	private Pedido pedido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFaturamentoEnderecoNome() {
		return FaturamentoEnderecoNome;
	}

	public void setFaturamentoEnderecoNome(String faturamentoEnderecoNome) {
		FaturamentoEnderecoNome = faturamentoEnderecoNome;
	}

	public String getFaturamentoEnderecoRua() {
		return FaturamentoEnderecoRua;
	}

	public void setFaturamentoEnderecoRua(String faturamentoEnderecoRua) {
		FaturamentoEnderecoRua = faturamentoEnderecoRua;
	}

	public String getFaturamentoEnderecoCidade() {
		return FaturamentoEnderecoCidade;
	}

	public void setFaturamentoEnderecoCidade(String faturamentoEnderecoCidade) {
		FaturamentoEnderecoCidade = faturamentoEnderecoCidade;
	}

	public String getFaturamentoEnderecoEstado() {
		return FaturamentoEnderecoEstado;
	}

	public void setFaturamentoEnderecoEstado(String faturamentoEnderecoEstado) {
		FaturamentoEnderecoEstado = faturamentoEnderecoEstado;
	}

	public String getFaturamentoEnderecoCep() {
		return FaturamentoEnderecoCep;
	}

	public void setFaturamentoEnderecoCep(String faturamentoEnderecoCep) {
		FaturamentoEnderecoCep = faturamentoEnderecoCep;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


}
