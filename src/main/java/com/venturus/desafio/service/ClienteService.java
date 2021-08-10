package com.venturus.desafio.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.venturus.desafio.entity.Cliente;

@Component
public interface ClienteService {

	public Page<Cliente> findAll(String nome, Integer page, Integer size);

	public Cliente save(Cliente cliente);

	public Optional<Cliente> update(Cliente cliente);

	public void delete(Cliente cliente);

}
