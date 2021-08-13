package com.venturus.desafio;

import com.venturus.desafio.entity.Cliente;
import com.venturus.desafio.service.ClienteService;
import javax.annotation.Resource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
class ServicoTest2 {

	@Resource
	ClienteService clienteService;

	static Cliente cliente = null;

	static Cliente clienteAlt = null; 
	
	static Cliente clienteDelet = null;

	@BeforeAll
	static void setup() {

		cliente = new Cliente();
		cliente.setNome("clientenovo");
		cliente.setCnpj("7687678670");

		clienteAlt = new Cliente();
		clienteAlt.setNome("clientenovoalt");
		clienteAlt.setCnpj("7687678678"); 
		
		clienteDelet = new Cliente();
		clienteDelet.setNome("clientenovodelet");
		clienteDelet.setCnpj("7687678677");
	}

	@AfterAll
	static void tearDown() {

		cliente = null;
		clienteAlt = null;
		clienteDelet = null;
	}

	@DisplayName("Salvar cliente com sucesso")
	@Test
	void testSalvarCliente() {

		assertNotNull(clienteService.save(cliente));
		clienteService.delete(cliente);
	}

	@DisplayName("Atualizar cliente com sucesso")
	@Test
	void testAtualizarCliente() {
		Cliente cli = clienteService.save(clienteAlt);
		assertNotNull(clienteService.update(cli));
		clienteService.delete(clienteAlt);
	}

	@DisplayName("Buscar clientes")
	@Test
	void testBuscarTodosOsClientes() {

		assertNotNull(clienteService.findAll(clienteAlt.getNome(), 0, 10));
	}

	@DisplayName("Deletar cliente")
	@Test
	void testDeletarCliente() {
		Cliente cli = clienteService.save(clienteDelet);
		clienteService.delete(cli);
	}
}
