package com.venturus.desafio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Contrato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "numero", nullable = false)
	private Long numero;

	@Column(name = "vigenciaMes", nullable = false)
	private Integer vigenciaMes;

	@Column(name = "cliente", nullable = false)
	@OneToOne
	private Cliente cliente;

	@Column(name = "servico", nullable = false)
	@OneToOne
	private Servico servico;

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}
