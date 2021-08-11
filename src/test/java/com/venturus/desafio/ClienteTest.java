package com.venturus.desafio;

import javax.annotation.Resource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.venturus.desafio.entity.Cliente;
import com.venturus.desafio.service.ClienteService;

@SpringBootTest
class ClienteTest {

	@Resource
	ClienteService clienteService;

	static Cliente cliente = null;

	static Cliente clienteAlt = null;

	@BeforeAll
	public static void beforeAll() {
		cliente = new Cliente();
		cliente.setNome("clientenovo");
		cliente.setCnpj("7687678678");

		clienteAlt = new Cliente();
		clienteAlt.setNome("clientenovoalt");
		clienteAlt.setCnpj("7687678678");

	}

	@AfterAll
	public static void afterAll() {
		cliente = null;
		clienteAlt = null;
	}

	@Test
	public void testSaveCliente() {
		Cliente cli = clienteService.save(cliente);
		clienteAlt.setId(cli.getId());
	}

	@Test
	public void testUpdateCliente() {
		clienteService.update(clienteAlt);
	}

	@Test
	public void testFindAllCliente() {
		clienteService.findAll(clienteAlt.getNome(), 0, 10);
	}

}
