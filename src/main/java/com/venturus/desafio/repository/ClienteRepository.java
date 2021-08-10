package com.venturus.desafio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.venturus.desafio.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

	@Query("FROM Cliente c "
			+ "WHERE nome like '%:nome%'")
	Page<Cliente> findAll(@Param("nome") String nome, Pageable Pageable);
	
}
