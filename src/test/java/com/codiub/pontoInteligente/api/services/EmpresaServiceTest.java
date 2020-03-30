package com.codiub.pontoInteligente.api.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

import com.codiub.pontoInteligente.api.entities.Empresa;
import com.codiub.pontoInteligente.api.repositories.EmpresaRepository;


@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)

public class EmpresaServiceTest {
	
	@MockBean
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	private static final String CNPJ =  "13246598746";
	
	@BeforeAll
	public void setUp() throws Exception {
		BDDMockito.given(this.empresaRepository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
		BDDMockito.given(this.empresaRepository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
	}
	
	@Test
	public void testBuscarEmpresaPorCnpj() {
		Optional<Empresa> empresa = this.empresaService.buscarPorCnpj(CNPJ);
		
		assertNotNull(empresa);
	}
	
	@Test
	public void testPersistirEmpresa() {
		Empresa empresa = this.empresaService.persistir(new Empresa());
		
		assertNotNull(empresa);
	}
	
	
}
