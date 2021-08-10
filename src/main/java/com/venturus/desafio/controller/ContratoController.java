package com.venturus.desafio.controller;

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
import com.venturus.desafio.entity.Contrato;
import com.venturus.desafio.service.ContratoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("contrato")
public class ContratoController {

	@Autowired
	ContratoService contratoService;

	/**
	 * Find all clients
	 * 
	 * @param id
	 * @param name
	 * @param cpf
	 * @param page
	 * @param size
	 * @return
	 */
	@ApiOperation("Find all clients")
	@GetMapping
	public ResponseEntity<?> findAll(@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "size", required = true) Integer size) {

		/*
		 * Cliente cliente = Optional.of(new Cliente()) .map(param -> {
		 * param.setNome(nome); param.setCpf(cpf); param.getDataNascimento(); return
		 * param; }).orElseThrow();
		 */

		return new ResponseEntity<Page<Contrato>>(contratoService.findAll(nome, page, size), HttpStatus.OK);
	}

	/**
	 * Create client
	 * 
	 * @param cliente
	 * @return
	 */
	@ApiOperation("Create client")
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Contrato contrato) {

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(Optional.of(contrato).map(contratoService::save).orElseThrow());
	}

	/**
	 * Update client
	 * 
	 * @param cliente
	 * @return
	 */
	@ApiOperation("Update client")
	@PutMapping
	public ResponseEntity<Optional<Contrato>> update(@RequestBody Contrato contrato) {

		return new ResponseEntity<Optional<Contrato>>(Optional.of(contrato).map(contratoService::update).orElseThrow(),
				HttpStatus.OK);
	}

	/**
	 * Delete client
	 * 
	 * @param cliente
	 */
	@ApiOperation("Delete client")
	@DeleteMapping
	public void delete(@RequestBody Contrato contrato) {

		contratoService.delete(contrato);
	}

}