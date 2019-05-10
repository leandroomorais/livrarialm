package br.com.livrarialm.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;


@Entity
public class Livro implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "Titulo é uma informação obrigatória")
	private String titulo;
	
	@Column(nullable=false, length = 100)
	private int ano;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "Sinopse é uma informação obrigatória")
	private String sinopse;
	
	@Column(nullable=false, length = 100)
	private int isbn;
	
	private int edicao;
	
	@Column(nullable=false, length = 100)
	private double peso;
	
	@Column(nullable=false, length = 100)
	private double preco;
	
	@ManyToOne
	@JoinTable(name="editora_id")
	public Editora editora;
	
	@ManyToOne
	@JoinTable(name="categoria_id")
	public Categoria categoria;
	
	@ManyToMany
	@JoinTable(name="autor_id")
	public List<Autor> autor;


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


	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Autor> getAutor() {
		return autor;
	}

	public void setAutor(List<Autor> autor) {
		this.autor = autor;
	}
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
