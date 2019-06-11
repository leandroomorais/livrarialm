package br.com.livrarialm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private Date dataPedido;
	private Date dataPagamento;
	private String formaPagamento;
	private String statusPedido;
	private BigDecimal total;
	
	
}
