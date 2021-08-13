package com.venturus.desafio.controller;

import com.venturus.desafio.entity.Servico;
import com.venturus.desafio.service.ServicoService;
import io.swagger.annotations.ApiOperation;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	ServicoService servicoService;

	/**
	 * Buscar Servicos 
	 * @param id
	 * @param nome
	 * @param page
	 * @param size
	 * @return
	 */
	@ApiOperation("Buscar servicos")
	@GetMapping
	public ResponseEntity<?> findAll(@RequestParam(value = "nome", required = true) String nome, 
			@RequestParam (value = "page", required = true) Integer page, 
			@RequestParam(value = "size", required = true) Integer size) {

		return new ResponseEntity<Page<Servico>>(servicoService.findAll(nome, page, size), HttpStatus.OK);
	}

	/**
	 * Salvar servico 
	 * @param servico
	 * @return
	 */
	@ApiOperation("Salvar servico")
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Servico servico) {
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(Optional.of(servico)
				.map(servicoService::save)
				.orElseThrow());
	}

	/**
	 * Atualizar servico 
	 * @param servico
	 * @return
	 */
	@ApiOperation("Deletar servico")
	@PutMapping
	public ResponseEntity<Optional<Servico>> update(@RequestBody Servico servico) {

		return new ResponseEntity<Optional<Servico>>(Optional.of(servico).map(servicoService::update).orElseThrow(),
				HttpStatus.OK);
	}

	/**
	 * Deletar servico 
	 * @param servico
	 */
	@ApiOperation("Deletar servico")
	@DeleteMapping
	public void delete(@RequestBody Servico servico) {
		
		servicoService.delete(servico);
	}

}
