package com.codiub.pontoInteligente.api.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.codiub.pontoInteligente.api.entities.Funcionario;
import com.codiub.pontoInteligente.api.repositories.FuncionarioRepository;
import com.codiub.pontoInteligente.api.services.FuncionarioService;


@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)

public class FuncionarioServiceTest  {
	
	@MockBean
	private FuncionarioRepository funcionarioReporisoty;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@BeforeAll
	public void setUp() throws Exception {
		BDDMockito.given(this.funcionarioReporisoty.save(Mockito.any(Funcionario.class))).willReturn(new Funcionario()) ;
		//BDDMockito.given(this.funcionarioReporisoty.findOne(Mockito.anyLong())).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioReporisoty.findByEmail(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioReporisoty.findByCpf(Mockito.anyString())).willReturn(new Funcionario());
		
	}
	
	@Test
	public void testPersistirFuncionario() {
		Funcionario funcionario = this.funcionarioService.persistir(new Funcionario());
		
		assertNotNull(funcionario);
	}
	
	@Test
	public void testBuscarFuncionarioPorCpf() {
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorCpf("123456789");
		
		assertTrue(funcionario.isPresent());
		
	}
	
	@Test
	public void testBuscarFuncionarioPorEmail() {
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorEmail("fdsafkjlçk@hotmail");
		
		assertTrue(funcionario.isPresent());
	}
	

}
