package com.venturus.desafio.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contrato")
public class Contrato implements Serializable {

	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	/**
	 * Numero
	 */
	@Column(name = "numero")
	private Long numero;

	/**
	 * Vigencia mes
	 */
	@Column(name = "vigenciaMes")
	private Integer vigenciaMes;

	/**
	 * Id Cliente
	 */
	@Column(name = "idCliente")
	private Integer idCliente;

	/**
	 * Id Servico
	 */
	@Column(name = "idServico")
	private Integer idServico;

	private String cnpj;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Integer getVigenciaMes() {
		return vigenciaMes;
	}

	public void setVigenciaMes(Integer vigenciaMes) {
		this.vigenciaMes = vigenciaMes;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
