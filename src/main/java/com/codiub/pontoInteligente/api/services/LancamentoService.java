package com.codiub.pontoInteligente.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.codiub.pontoInteligente.api.entities.Lancamento;



public interface LancamentoService {

	/**
	 * Retorna uma lista paginada de lançamentos de um determinado funcionario
	 * @author elvis
	 *
	 */
	Page<Lancamento> BuscarPorFuncionarioId(Long FuncionarioId, PageRequest pageRequest);
	
	
	/**
	 * Retorna o Lançamento por ID
	 * @param id
	 * @return
	 */
	Optional<Lancamento> BuscarPorId(Long id);
	
	
	/**
	 * Persisti um lançamento na base de dados
	 * @param lancamento
	 * @return
	 */
	Lancamento Persistir(Lancamento lancamento);
	
	/**
	 * Remove um lançamento da base de dados
	 * @param id
	 */
	void Remover(Long id);
	
	
}
