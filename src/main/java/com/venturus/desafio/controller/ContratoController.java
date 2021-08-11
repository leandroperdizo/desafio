package com.venturus.desafio.controller;

import com.venturus.desafio.entity.Contrato;
import com.venturus.desafio.service.ContratoService;
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
@RequestMapping("/contrato")
public class ContratoController {

	@Autowired
	ContratoService contratoService;

	/**
	 * Find all contracts
	 * 
	 * @param id
	 * @param numero
	 * @param vigenciaMes
	 * @param cliente
	 * @param servico
	 * @param page
	 * @param size
	 * @return
	 */
	@ApiOperation("Find all contracts")
	@GetMapping
	public ResponseEntity<?> findAll(@RequestParam(value = "cnpj", required = true) String cnpj,
			@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "size", required = true) Integer size) {

		return new ResponseEntity<Page<Contrato>>(contratoService.findAll(cnpj, page, size), HttpStatus.OK);
	}

	/**
	 * Create contract
	 * 
	 * @param contract
	 * @return
	 */
	@ApiOperation("Create contract")
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Contrato contrato) {

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(Optional.of(contrato).map(contratoService::save).orElseThrow());
	}

	/**
	 * Update contract
	 * 
	 * @param contract
	 * @return
	 */
	@ApiOperation("Update contract")
	@PutMapping
	public ResponseEntity<Optional<Contrato>> update(@RequestBody Contrato contrato) {

		return new ResponseEntity<Optional<Contrato>>(Optional.of(contrato).map(contratoService::update).orElseThrow(),
				HttpStatus.OK);
	}

	/**
	 * Delete contract
	 * 
	 * @param contract
	 */
	@ApiOperation("Delete contract")
	@DeleteMapping
	public void delete(@RequestBody Contrato contrato) {

		contratoService.delete(contrato);
	}

}
