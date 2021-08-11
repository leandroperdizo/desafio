package com.venturus.desafio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.venturus.desafio.entity.Cliente;
import com.venturus.desafio.entity.Contrato;

@Repository
public interface ContratoRepository extends CrudRepository<Contrato, Integer>{

	@Query("FROM Contrato c " 
			+ "WHERE nome = :cnpj")
	Page<Contrato> findAll(@Param("cnpj") String cnpj, Pageable Pageable);
	
}
