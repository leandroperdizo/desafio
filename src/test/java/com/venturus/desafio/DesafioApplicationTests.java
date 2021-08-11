package com.venturus.desafio;

import javax.annotation.Resource;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.venturus.desafio.entity.Cliente;
import com.venturus.desafio.repository.ClienteRepository;

@SpringBootTest
class DesafioApplicationTests {

	@Resource
	ClienteRepository clienteRepository; 
	
	Cliente cliente = null;
	
	@BeforeAll
	public void beforeAll() {
		cliente = new Cliente();
		cliente.setNome("clientenovo");
		cliente.setCnpj("7687678678");
	} 
	
	@AfterAll
	public void afterAll() {
		cliente = null;
	}

	@Test
	public void testSaveCliente() {
		clienteRepository.save(cliente);
	}

}
