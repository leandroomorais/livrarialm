package com.dsc.livrarialmfinal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Livro implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "Titulo é uma informação obrigatória")
	private String titulo;
	
	@Column(nullable=false, length = 500)
	@NotBlank(message = "URL da Imagem é uma informação obrigatória")
	private String url;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "Ano é uma informação obrigatória")
	private String ano;
	
	@Column(nullable=false, length = 1000)
	@NotBlank(message = "Sinopse é uma informação obrigatória")
	private String sinopse;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "ISBN é uma informação obrigatória")
	private String isbn;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "Edição é uma informação obrigatória")
	private String edicao;
	
	@Column(nullable=false, length = 100)
	private String peso;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable=false, length = 10)
	private double preco;
	
	@ManyToOne
	@JoinTable(name="livro_editora")
	public Editora editora;
	
	@ManyToOne
	@JoinTable(name="livro_categoria")
	public Categoria categoria;
	
	@ManyToMany
	@JoinTable(name="livro_autor")
	public List<Autor> autor;
	
	@OneToMany
	@JsonIgnore
	private List<ItemPedido> itemPedidoList;
	

		
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

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<ItemPedido> getItemPedidoList() {
		return itemPedidoList;
	}

	public void setItemPedidoList(List<ItemPedido> itemPedidoList) {
		this.itemPedidoList = itemPedidoList;
	}
	
}
