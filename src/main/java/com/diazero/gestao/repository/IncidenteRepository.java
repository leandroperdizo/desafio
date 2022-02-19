package com.diazero.gestao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.diazero.gestao.entity.Incidente;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Integer> {

	@Query("FROM Cliente c " 
			+ "WHERE nome = :nome")
	Page<Incidente> findAll(@Param("nome") String nome, Pageable Pageable);

	@Query("SELECT count(c.id) FROM Cliente c " 
			+ "WHERE cnpj = :cnpj")
	Integer verificaDuplicidade(@Param("cnpj") String cnpj);

}
