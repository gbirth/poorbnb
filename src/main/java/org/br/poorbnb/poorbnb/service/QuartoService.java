package org.br.poorbnb.poorbnb.service;

import org.br.poorbnb.poorbnb.dto.QuartoDTO;
import org.br.poorbnb.poorbnb.exception.ResourceNotFoundException;
import org.br.poorbnb.poorbnb.model.Quarto;

import javax.management.AttributeNotFoundException;

public interface QuartoService {

	Quarto obterQuartoPorId(Long quartoId) throws ResourceNotFoundException;
	Quarto salvarQuarto(Quarto quarto);
	Quarto atualizaQuarto(Long quartoId, QuartoDTO quartoAlteracoes) throws ResourceNotFoundException, AttributeNotFoundException;
}
