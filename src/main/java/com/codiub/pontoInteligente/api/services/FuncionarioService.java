package com.codiub.pontoInteligente.api.services;

import java.util.Optional;

import com.codiub.pontoInteligente.api.entities.Funcionario;

public interface FuncionarioService {
	
	/**
	 * Persiste um funcionario na base de dados
	 * @param funcionario
	 * @return
	 */
	Funcionario persistir(Funcionario funcionario);
	
	
	/**
	 * Busca e retorna um funcionario dado um cpf
	 * @param cpf
	 * @return
	 */
	Optional<Funcionario>buscarPorCpf(String cpf);
	
	
	/**
	 * Busca e retorna um funcionário dado um email
	 * @param email
	 * @return
	 */
	Optional<Funcionario>buscarPorEmail(String email);
	
	/**
	 * Busca e retorna um funcionário por ID.
	 * 
	 * @param id
	 * @return Optional<Funcionario>
	 */
	Optional<Funcionario> buscarPorId(Long id);
	

}
