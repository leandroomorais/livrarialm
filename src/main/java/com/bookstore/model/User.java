package com.bookstore.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bookstore.model.security.Authority;
import com.bookstore.model.security.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable = false, updatable = false)
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	@Column(name="email", nullable = false, updatable = false)
	private String email;
	private String telefone;
	private boolean enabled=true;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private CarroCompra carroCompra;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<UserRemessa> userRemessaList;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<UserPagamento> userPagamentoList;
	
	@OneToMany(mappedBy = "user")
	private List<Pedido> pedidoList;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public CarroCompra getCarroCompra() {
		return carroCompra;
	}
	public void setCarroCompra(CarroCompra carroCompra) {
		this.carroCompra = carroCompra;
	}
	public List<UserRemessa> getUserRemessaList() {
		return userRemessaList;
	}
	public void setUserRemessaList(List<UserRemessa> userRemessaList) {
		this.userRemessaList = userRemessaList;
	}
	public List<UserPagamento> getUserPagamentoList() {
		return userPagamentoList;
	}
	public void setUserPagamentoList(List<UserPagamento> userPagamentoList) {
		this.userPagamentoList = userPagamentoList;
	}
	public List<Pedido> getPedidoList() {
		return pedidoList;
	}
	public void setPedidoList(List<Pedido> pedidoList) {
		this.pedidoList = pedidoList;
	}
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorites = new HashSet<>();
		userRoles.forEach(ur -> authorites.add(new Authority(ur.getRole().getName())));
		
		return authorites;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	
}
