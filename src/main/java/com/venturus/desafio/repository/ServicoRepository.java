package com.venturus.desafio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.venturus.desafio.entity.Cliente;
import com.venturus.desafio.entity.Servico;

@Repository
public interface ServicoRepository extends CrudRepository<Servico, Integer>{

	@Query("FROM Servico c " 
			+ "WHERE nome = :nome")
	Page<Servico> findAll(@Param("nome") String nome, Pageable Pageable);
	
}
