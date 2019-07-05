package com.dsc.livrarialmfinal.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
public class User{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "Nome é uma informação obrigatória")
	private String nome;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "E-mail é uma informação obrigatória")
	private String username;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "Senha é uma informação obrigatória")
	private String password;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "Rua é uma informação obrigatória")
	private String rua;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "Bairro é uma informação obrigatória")
	private String bairro;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "Cidade é uma informação obrigatória")
	private String cidade;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "o CEP é uma informação obrigatória")
	private String cep;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "Número da casa é uma informação obrigatória")
	private String numero;
	
	@Column(nullable=false, length = 100)
	@NotBlank(message = "UF é uma informação obrigatória")
	private String uf;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private Carrinho carrinho;
	
//	@ManyToMany
//	@JoinTable( 
//	        name = "usuarios_roles", 
//	        joinColumns = @JoinColumn(
//	          name = "usuario_id", referencedColumnName = "id"), 
//	        inverseJoinColumns = @JoinColumn(
//	          name = "role_id", referencedColumnName = "nomeRole"))
//	private List<Role> roles;
	
	
	
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
//	public List<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}



	
}
