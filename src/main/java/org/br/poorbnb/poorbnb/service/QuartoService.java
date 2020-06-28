package org.br.poorbnb.poorbnb.service;

import org.br.poorbnb.poorbnb.exception.ResourceNotFoundException;
import org.br.poorbnb.poorbnb.model.Quarto;

public interface QuartoService {
	public Quarto obterQuartoPorId(Long quartoId) 	throws ResourceNotFoundException ;		

	public Quarto criarQuarto(Quarto quarto) ;

	
	public Quarto atualizaQuarto(Long quartoId, Quarto quartoDetails) throws ResourceNotFoundException ;

	  

}
