package com.venturus.desafio.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.venturus.desafio.entity.Contrato;
import com.venturus.desafio.repository.ContratoRepository;
import com.venturus.desafio.service.ContratoService;

@Service
public class ContratoServiceImpl implements ContratoService {

	@Autowired
	private ContratoRepository contratoRepository;

	@Override
	public Page<Contrato> findAll(String nome, Integer page, Integer size) {

		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
		return contratoRepository.findAll(nome, pageRequest);
	}

	@Override
	public Contrato save(Contrato contrato) {

		return Optional.ofNullable(contrato).filter(param -> !contratoRepository.existsById(contrato.getId()))
				.map(param -> contratoRepository.save(contrato)).orElseGet(() -> new Contrato());
	}

	@Override
	public Optional<Contrato> update(Contrato contrato) {

		return contratoRepository.findById(contrato.getId()).map(param -> {
			param.setNumero(contrato.getNumero());
			param.setVigenciaMes(contrato.getVigenciaMes());
			param.setCliente(contrato.getCliente());
			param.setServico(contrato.getServico());
			return contratoRepository.save(param);
		});
	}

	@Override
	public void delete(Contrato contrato) {
		contratoRepository.delete(contrato);
	}
}