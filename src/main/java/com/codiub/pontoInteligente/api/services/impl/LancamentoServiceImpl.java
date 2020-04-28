package com.codiub.pontoInteligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.codiub.pontoInteligente.api.entities.Lancamento;
import com.codiub.pontoInteligente.api.repositories.LancamentoRepository;
import com.codiub.pontoInteligente.api.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService{
	
	private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	
	@Override
	public Page<Lancamento> BuscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
		log.info("Bucando lançamentos para o funcionario ID {}", funcionarioId);
		return lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
	}

	@Override
	public Optional<Lancamento> BuscarPorId(Long id) {
		log.info("Bucando lançamentos para o funcionario ID {}", id);
	//	return Optional.ofNullable(lancamentoRepository.findOne(id));
		return null;
	}

	@Override
	public Lancamento Persistir(Lancamento lancamento) {
		log.info("Persistindo lancamento {}", lancamento);
		return this.lancamentoRepository.save(lancamento);
	}

	@Override
	public void Remover(Lancamento lancamento) {
		log.info("Persistindo lancamento {}", lancamento);
		this.lancamentoRepository.delete(lancamento);
		
	}

}
