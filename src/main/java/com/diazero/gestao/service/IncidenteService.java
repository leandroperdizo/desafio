package com.diazero.gestao.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.diazero.gestao.entity.Incidente;

@Component
public interface IncidenteService {

	public Page<Incidente> findAll(String nome, Integer page, Integer size);

	public Incidente save(Incidente cliente);

	public Optional<Incidente> update(Incidente cliente);

	public void delete(Incidente cliente);

}
