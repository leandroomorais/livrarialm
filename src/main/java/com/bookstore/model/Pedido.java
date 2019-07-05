package com.bookstore.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_order")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date pedidoDate;
	private Date remessaDate;
	private String remessaMethod;
	private String pedidoStatus;
	private BigDecimal pedidoTotal;
	
	@OneToMany(mappedBy = "pedido", cascade=CascadeType.ALL )
	private List<CarroItem> carroItemList;
	
	@OneToOne(cascade=CascadeType.ALL)
	private RemessaEndereco remessaEndereco;
	
	@OneToOne(cascade=CascadeType.ALL)
	private FaturamentoEndereco faturamentoEndereco;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Pagamento pagamento;
	
	@ManyToOne
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPedidoDate() {
		return pedidoDate;
	}

	public void setPedidoDate(Date pedidoDate) {
		this.pedidoDate = pedidoDate;
	}

	public Date getRemessaDate() {
		return remessaDate;
	}

	public void setRemessaDate(Date remessaDate) {
		this.remessaDate = remessaDate;
	}

	public String getRemessaMethod() {
		return remessaMethod;
	}

	public void setRemessaMethod(String remessaMethod) {
		this.remessaMethod = remessaMethod;
	}

	public String getPedidoStatus() {
		return pedidoStatus;
	}

	public void setPedidoStatus(String pedidoStatus) {
		this.pedidoStatus = pedidoStatus;
	}

	public BigDecimal getPedidoTotal() {
		return pedidoTotal;
	}

	public void setPedidoTotal(BigDecimal pedidoTotal) {
		this.pedidoTotal = pedidoTotal;
	}

	public List<CarroItem> getCarroItemList() {
		return carroItemList;
	}

	public void setCarroItemList(List<CarroItem> carroItemList) {
		this.carroItemList = carroItemList;
	}

	public RemessaEndereco getRemessaEndereco() {
		return remessaEndereco;
	}

	public void setRemessaEndereco(RemessaEndereco remessaEndereco) {
		this.remessaEndereco = remessaEndereco;
	}

	public FaturamentoEndereco getFaturamentoEndereco() {
		return faturamentoEndereco;
	}

	public void setFaturamentoEndereco(FaturamentoEndereco faturamentoEndereco) {
		this.faturamentoEndereco = faturamentoEndereco;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	
	
	
}
