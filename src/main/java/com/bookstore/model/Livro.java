package com.bookstore.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "Titulo é uma informação obrigatória")
	private String titulo;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "Ano é uma informação obrigatória")
	private String ano;
	
	@Column(nullable=false, length = 100)
	private int isbn;
	
	private int edicao;
	
	@Column(nullable=false, length = 100)
	private double peso;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable=false, length = 10)
	private double preco;
	
	private boolean active=true;
	
	@Column(nullable=false, length = 1000)
	@NotBlank(message = "URL da Imagem é uma informação obrigatória")
	private String url;
	
	@Column(columnDefinition="text")
	@NotBlank(message = "Sinopse do Livro é uma informação obrigatória")
	private String sinopse;
	
	
	private int inStockNumber;
	
	@ManyToOne
	@JoinTable(name="livro_editora")
	public Editora editora;
	
	@ManyToOne
	@JoinTable(name="livro_categoria")
	public Categoria categoria;
	
	@ManyToMany
	@JoinTable(name="livro_autor")
	public List<Autor> autor;
	
	
	@OneToMany(mappedBy = "book")
	@JsonIgnore
	private List<LivroParaCarroItem> livroParaCarroList;



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
	
	public String getAno() {
		return ano;
	}



	public void setAno(String ano) {
		this.ano = ano;
	}



	public int getIsbn() {
		return isbn;
	}



	public void setIsbn(int isbn) {
		this.isbn = isbn;
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



	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getSinopse() {
		return sinopse;
	}



	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}



	public int getInStockNumber() {
		return inStockNumber;
	}



	public void setInStockNumber(int inStockNumber) {
		this.inStockNumber = inStockNumber;
	}



	public List<LivroParaCarroItem> getLivroParaCarroList() {
		return livroParaCarroList;
	}



	public void setLivroParaCarroList(List<LivroParaCarroItem> livroParaCarroList) {
		this.livroParaCarroList = livroParaCarroList;
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



	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	
	
}
