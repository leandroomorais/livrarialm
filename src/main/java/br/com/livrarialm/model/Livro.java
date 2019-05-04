package br.com.livrarialm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Livro implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "Campo obrigatório")
	private String titulo;
	
	@Column(nullable=false, length = 100)
	private int ano;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "Campo obrigatório")
	private String sinopse;
	
	@Column(nullable=false, length = 100)
	private int isbn;
	
	private int edicao;
	
	@Column(nullable=false, length = 100)
	private double peso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}



	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
