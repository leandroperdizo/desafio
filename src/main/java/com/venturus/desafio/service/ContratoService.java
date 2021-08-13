package com.venturus.desafio.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.venturus.desafio.entity.Contrato;

@Component
public interface ContratoService {

	public Page<Contrato> findAll(String cnpj, Integer page, Integer size); 
	
	public Contrato save(Contrato contrato); 
	
	public Optional<Contrato> update(Contrato contrato); 
	
	public void delete(Contrato contrato); 	
	
}
