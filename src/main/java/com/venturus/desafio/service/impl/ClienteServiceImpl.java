package com.venturus.desafio.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.venturus.desafio.entity.Cliente;
import com.venturus.desafio.repository.ClienteRepository;
import com.venturus.desafio.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Page<Cliente> findAll(String nome, Integer page, Integer size) {

		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
		return clienteRepository.findAll(nome, pageRequest);
	}

	@Override
	public Cliente save(Cliente cliente) {

		return Optional.ofNullable(cliente)
				.filter(param -> clienteRepository.verificaDuplicidade(cliente.getCnpj()) == 0)
				.map(param -> clienteRepository.save(cliente)).orElseGet(() -> new Cliente());
	}

	@Override
	public Optional<Cliente> update(Cliente cliente) {

		return clienteRepository.findById(cliente.getId()).map(param -> {
			param.setNome(cliente.getNome());
			param.setCnpj(cliente.getCnpj());
			return clienteRepository.save(param);
		});
	}

	@Override
	public void delete(Cliente cliente) {

		clienteRepository.delete(cliente);
	}
}
