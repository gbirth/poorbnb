package org.br.poorbnb.poorbnb.service;

import java.util.List;
import java.util.Map;

import org.br.poorbnb.poorbnb.exception.ResourceNotFoundException;
import org.br.poorbnb.poorbnb.model.Quarto;

public interface QuartoService {
	
	Quarto obterQuartoPorId(Long quartoId) throws ResourceNotFoundException;
	
	Quarto criarQuarto(Quarto quarto);

	Quarto atualizaQuarto(Long quartoId, Quarto quartoDetails) throws ResourceNotFoundException ;


	
}
