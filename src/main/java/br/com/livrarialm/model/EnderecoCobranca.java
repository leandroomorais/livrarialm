package br.com.livrarialm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EnderecoCobranca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String NomeEndereco;
	private String rua1;
	private String rua2;
	private String cidade;
	private String estado;
	private String cep;
	
	

}
