package com.bookstore.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;


@Entity
public class Autor {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 100)
	@NotBlank(message = "Nome é um campo obrigatório")
	private String nome;
	
	@Column(nullable = false, length = 100)
	@NotBlank(message = "Email é um campo obrigatório")
	@Email
	private String email;
	
	@Column(nullable = false, length = 100)
	@NotBlank(message = "CPF é um campo obrigatório")
	@CPF
	private String cpf;
	
	@ManyToMany(mappedBy="autor")
	private List<Livro> livro;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

	public List<Livro> getLivro() {
		return livro;
	}

	public void setLivro(List<Livro> livro) {
		this.livro = livro;
	}

}
