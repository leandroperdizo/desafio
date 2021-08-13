package com.venturus.desafio;

import com.venturus.desafio.config.VenturusConfig;
import com.venturus.desafio.entity.Cliente;
import com.venturus.desafio.entity.Contrato;
import com.venturus.desafio.entity.Servico;
import com.venturus.desafio.service.ClienteService;
import com.venturus.desafio.service.ContratoService;
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
class ContratoTest {

	@Resource
	ClienteService clienteService; 
	
	@Resource
	ServicoService servicoService; 
	
	@Resource
	ContratoService contratoService;

	static Cliente cliente = null;

	static Cliente clienteAlt = null; 
	
	static Cliente clienteDelet = null; 
	
	static Servico servico = null;

	static Servico servicoAlt = null; 
	
	static Servico servicoDelet = null;
	
	static Contrato contrato = null;

	static Contrato contratoAlt = null; 
	
	static Contrato contratoDelet = null;

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
		
		servico = new Servico(); 
		servico.setNome("jhkljhjkhk"); 
		
		servicoAlt = new Servico(); 
		servicoAlt.setNome("jhkljhjkhk"); 
		
		servicoDelet = new Servico(); 
		servicoDelet.setNome("jhkljhjkhk");
		
		contrato = new Contrato();
		contrato.setNumero(100L); 
		contrato.setVigenciaMes(5);

		contratoAlt = new Contrato();
		contratoAlt.setNumero(101L); 
		contratoAlt.setVigenciaMes(5);
		
		contratoDelet = new Contrato();
		contratoDelet.setNumero(107L); 
		contratoDelet.setVigenciaMes(5); 	
		
	}

	@AfterAll
	static void tearDown() {

		contrato = null;
		contratoAlt = null;
		contratoDelet = null;
	}

	@DisplayName("Salvar contrato com sucesso")
	@Test
	void testSalvarContrato() {

		Cliente cli = clienteService.save(cliente); 		
		Servico serv = servicoService.save(servico);
		
		contrato.setIdCliente(cli.getId());
		contrato.setIdServico(serv.getId());
		
		assertNotNull(contratoService.save(contrato));
		contratoService.delete(contrato);
	}

	@DisplayName("Atualizar contrato com sucesso")
	@Test
	void testAtualizarContrato() {
		
		Cliente cli = clienteService.save(cliente); 		
		Servico serv = servicoService.save(servico);
		
		contratoAlt.setIdCliente(cli.getId());
		contratoAlt.setIdServico(serv.getId());
		
		Contrato con = contratoService.save(contratoAlt);
		assertNotNull(contratoService.update(con));
		contratoService.delete(contratoAlt);
	}

	@DisplayName("Buscar contratos")
	@Test
	void testBuscarTodosOsContrato() {

		Cliente cli = clienteService.save(cliente); 		
		Servico serv = servicoService.save(servico);
		
		contratoAlt.setIdCliente(cli.getId());
		contratoAlt.setIdServico(serv.getId());
		contratoAlt.setCnpj(cli.getCnpj());
		
		assertNotNull(contratoService.findAll(contratoAlt.getCnpj(), 0, 10));
		contratoService.delete(contratoAlt);
	}

	@DisplayName("Deletar contrato")
	@Test
	void testDeletarContrato() {
		
		Cliente cli = clienteService.save(cliente); 		
		Servico serv = servicoService.save(servico);
		
		contratoDelet.setIdCliente(cli.getId());
		contratoDelet.setIdServico(serv.getId());
		
		Contrato con = contratoService.save(contratoDelet);
		contratoService.delete(con);
	}
}
