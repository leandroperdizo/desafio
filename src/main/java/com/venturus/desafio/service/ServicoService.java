package com.venturus.desafio.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.venturus.desafio.entity.Servico;

@Component
public interface ServicoService {

	public Page<Servico> findAll(String nome, Integer page, Integer size); 
	
	public Servico save(Servico servico); 
	
	public Optional<Servico> update(Servico servico); 
	
	public void delete(Servico servico); 	
	
}
