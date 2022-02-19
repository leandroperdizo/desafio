package com.venturus.desafio;

import com.diazero.gestao.config.VenturusConfig;
import com.diazero.gestao.entity.Incidente;
import com.diazero.gestao.service.IncidenteService;

import javax.annotation.Resource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = "com.venturus.*")
@EntityScan(basePackages = "com.venturus.desafio.entity")
@ContextConfiguration(classes = { VenturusConfig.class }, loader = AnnotationConfigContextLoader.class)
@Transactional
class IncidenteTest {

	@Resource
	IncidenteService incidenteService;

	static Incidente cliente = null;

	static Incidente clienteAlt = null;

	static Incidente clienteDelet = null;

	@BeforeAll
	static void setup() {

		cliente = new Incidente();
		cliente.setName("clientenovo");
		cliente.setDescription("7687678670");

		clienteAlt = new Incidente();
		clienteAlt.setName("clientenovoalt");
		clienteAlt.setDescription("7687678678");

		clienteDelet = new Incidente();
		clienteDelet.setName("clientenovodelet");
		clienteDelet.setDescription("7687678677");
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

		assertNotNull(incidenteService.save(cliente));
		incidenteService.delete(cliente);
	}

	@DisplayName("Atualizar cliente com sucesso")
	@Test
	void testAtualizarCliente() {
		Incidente cli = incidenteService.save(clienteAlt);
		cli.setName("clienteNome");
		assertNotNull(incidenteService.update(cli));
		incidenteService.delete(clienteAlt);
	}

	@DisplayName("Buscar clientes")
	@Test
	void testBuscarTodosOsClientes() {

		assertNotNull(incidenteService.findAll(clienteAlt.getName(), 0, 10));
	}

	@DisplayName("Deletar cliente")
	@Test
	void testDeletarCliente() {
		Incidente cli = incidenteService.save(clienteDelet);
		incidenteService.delete(cli);
	}
}
