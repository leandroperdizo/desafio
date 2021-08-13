package com.venturus.desafio;

import com.venturus.desafio.config.VenturusConfig;
import com.venturus.desafio.entity.Servico;
import com.venturus.desafio.service.ServicoService;
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
class ServicoTest {

	@Resource
	ServicoService servicoService;

	static Servico servico = null;

	static Servico servicoAlt = null; 
	
	static Servico servicoDelet = null;

	@BeforeAll
	static void setup() {

		servico = new Servico();
		servico.setNome("clientenovo");

		servicoAlt = new Servico();
		servicoAlt.setNome("clientenovoalt");
		
		servicoDelet = new Servico();
		servicoDelet.setNome("clientenovodelet");
	}

	@AfterAll
	static void tearDown() {

		servico = null;
		servicoAlt = null;
		servicoDelet = null;
	}

	@DisplayName("Salvar serviço com sucesso")
	@Test
	void testSalvarCliente() {

		assertNotNull(servicoService.save(servico));
		servicoService.delete(servico);
	}

	@DisplayName("Atualizar serviço com sucesso")
	@Test
	void testAtualizarCliente() {
		Servico cli = servicoService.save(servicoAlt);
		cli.setNome("clienteNome");
		assertNotNull(servicoService.update(cli));
		servicoService.delete(servicoAlt);
	}

	@DisplayName("Buscar serviços")
	@Test
	void testBuscarTodosOsClientes() {

		assertNotNull(servicoService.findAll(servicoAlt.getNome(), 0, 10));
	}

	@DisplayName("Deletar serviço")
	@Test
	void testDeletarCliente() {
		
		Servico cli = servicoService.save(servicoDelet);
		servicoService.delete(cli);
	}
}
