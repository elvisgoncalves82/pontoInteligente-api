package com.codiub.pontoInteligente.api.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.codiub.pontoInteligente.api.entities.Funcionario;
import com.codiub.pontoInteligente.api.entities.Lancamento;
import com.codiub.pontoInteligente.api.repositories.LancamentoRepository;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
public class LancamentoServiceTest {

	@MockBean
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@BeforeAll
	public void setUp() throws Exception {
		BDDMockito.given(this.lancamentoRepository.findByFuncionarioId(Mockito.anyLong(),Mockito.any(PageRequest.class))) 
			.willReturn(new PageImpl <Lancamento>(new ArrayList<Lancamento>()));
	//	BDDMockito.given(this.lancamentoRepository.findOne(Mockito.anyLong())).willReturn(new Lancamento());
		BDDMockito.given(this.lancamentoRepository.save(Mockito.any(Lancamento.class))).willReturn(new Lancamento()) ;		
	}
	
	//@Test
//	public void testBuscarlancamentoPorFuncionario() {
//		Optional<Lancamento>lancamento = this.lancamentoService.BuscarPorFuncionarioId(1, new PageRequest(0,1, null));
//	}
	
	@Test
	public void testBuscarLancamentoPorId() {
		Optional <Lancamento> lancamento = this.lancamentoService.BuscarPorId(1L);
	}
	
	@Test
	public void persistirLancamento() {
		Lancamento lancamento = this.lancamentoRepository.save(new Lancamento());
		assertNotNull(lancamento);
	}
	
	
	
}
