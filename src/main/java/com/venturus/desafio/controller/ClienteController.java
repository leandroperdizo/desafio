package com.venturus.desafio.controller;

import com.venturus.desafio.entity.Cliente;
import com.venturus.desafio.service.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	/**
	 * Buscar clientes 
	 * 
	 * @param id
	 * @param nome
	 * @param cpf
	 * @param page
	 * @param size
	 * @return
	 */
	@ApiOperation("Buscar clientes")
	@GetMapping
	public ResponseEntity<?> findAll(@RequestParam(value = "nome", required = true) String nome,
			@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "size", required = true) Integer size) {

		return new ResponseEntity<Page<Cliente>>(clienteService.findAll(nome, page, size), HttpStatus.OK);
	}

	/**
	 * Salvar cliente 
	 * 
	 * @param cliente
	 * @return
	 */
	@ApiOperation("Salvar cliente")
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cliente cliente) {

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(Optional.of(cliente).map(clienteService::save).orElseThrow());
	}

	/**
	 * Atualizar cliente 
	 * 
	 * @param cliente
	 * @return
	 */
	@ApiOperation("Atualizar cliente")
	@PutMapping
	public ResponseEntity<Optional<Cliente>> update(@RequestBody Cliente cliente) {

		return new ResponseEntity<Optional<Cliente>>(Optional.of(cliente).map(clienteService::update).orElseThrow(),
				HttpStatus.OK);
	}

	/**
	 * Deletar cliente 
	 * 
	 * @param cliente
	 */
	@ApiOperation("Deletar cliente")
	@DeleteMapping
	public void delete(@RequestBody Cliente cliente) {

		clienteService.delete(cliente);
	}

}
