package com.venturus.desafio.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.venturus.desafio.entity.Servico;
import com.venturus.desafio.repository.ServicoRepository;
import com.venturus.desafio.service.ServicoService;

@Service
public class ServicoServiceImpl implements ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	@Override
	public Page<Servico> findAll(String nome, Integer page, Integer size) {

		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
		return servicoRepository.findAll(nome, pageRequest);
	}

	@Override
	public Servico save(Servico servico) {

		return Optional.ofNullable(servico).filter(param -> !servicoRepository.existsById(servico.getId()))
				.map(param -> servicoRepository.save(servico)).orElseGet(() -> new Servico());
	}

	@Override
	public Optional<Servico> update(Servico servico) {

		return servicoRepository.findById(servico.getId()).map(param -> {
			param.setNome(servico.getNome());
			return servicoRepository.save(param);
		});
	}

	@Override
	public void delete(Servico servico) {
		servicoRepository.delete(servico);
	}
}
