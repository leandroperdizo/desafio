package com.diazero.gestao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "incidente")
@Getter
@Setter
public class Incidente implements Serializable {

	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idIncident")
	private Integer idIncident;

	/**
	 * Nome
	 */
	@Column(name = "name")
	private String name;

	/**
	 * CNPJ
	 */
	@Column(name = "description")
	private String description;
	
	/**
	 * CNPJ
	 */
	@Column(name = "createdAt")
	private Date createdAt;
	
	/**
	 * CNPJ
	 */
	@Column(name = "updatedAt")
	private Date updatedAt;
	
	/**
	 * CNPJ
	 */
	@Column(name = "closedAt")
	private Date closedAt;

	

}
