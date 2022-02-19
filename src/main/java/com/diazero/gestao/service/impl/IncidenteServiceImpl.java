package com.diazero.gestao.service.impl;

import com.diazero.gestao.entity.Incidente;
import com.diazero.gestao.repository.IncidenteRepository;
import com.diazero.gestao.service.IncidenteService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class IncidenteServiceImpl implements IncidenteService {

	@Autowired
	private IncidenteRepository clienteRepository;

	/**
	 * Buscar clientes 
	 */
	@Override
	public Page<Incidente> findAll(String nome, Integer page, Integer size) {

		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
		return clienteRepository.findAll(nome, pageRequest);
	}

	/**
	 * Salvar cliente 
	 */
	@Override
	public Incidente save(Incidente cliente) {

		return Optional.ofNullable(cliente)
				.map(param -> clienteRepository.save(cliente)).orElseGet(() -> new Incidente());
	}

	/**
	 * Atualizar cliente 
	 */
	@Override
	public Optional<Incidente> update(Incidente cliente) {

		return clienteRepository
				.findById(cliente.getIdIncident())
				.map(param -> {			
					param.setName(cliente.getName() == null ? param.getName() : cliente.getName());
			return clienteRepository.save(param);
		});
	}

	/**
	 * Deletar cliente 
	 */
	@Override
	public void delete(Incidente cliente) {

		clienteRepository.delete(cliente);
	}
}
