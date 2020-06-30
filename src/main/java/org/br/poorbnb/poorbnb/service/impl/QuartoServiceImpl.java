package org.br.poorbnb.poorbnb.service.impl;

import org.br.poorbnb.poorbnb.exception.ResourceNotFoundException;
import org.br.poorbnb.poorbnb.model.Quarto;
import org.br.poorbnb.poorbnb.repository.QuartoRepository;
import org.br.poorbnb.poorbnb.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class QuartoServiceImpl implements QuartoService {

	private QuartoRepository quartoRepository;

	@Autowired
	public QuartoServiceImpl(QuartoRepository quartoRepository) {
		this.quartoRepository = quartoRepository;
	}

	public Quarto obterQuartoPorId(Long quartoId) 	throws ResourceNotFoundException {
		Quarto quarto = quartoRepository.findById(quartoId)
				.orElseThrow(() -> new ResourceNotFoundException("Quarto não encontrado:: " + quartoId));
		return quarto;}

	public Quarto criarQuarto(Quarto quarto) {
		
		return quartoRepository.save(quarto);
	}

	@Override
	public void callProcedure() {
		this.quartoRepository.callValidaQuarto();
	}

	public Quarto atualizaQuarto(Long quartoId, Quarto quartoDetails) throws ResourceNotFoundException {
		Quarto quarto = quartoRepository.findById(quartoId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario not found on :: " + quartoId));
		quarto.setDescricao(quartoDetails.getDescricao());
		//criar validação de preço
		//if (quartoDetails.getPreco().compareTo(150) == 0) {
		quarto.setPreco(quartoDetails.getPreco());
		//}
		quarto.setOcupadoSN(quartoDetails.getOcupadoSN());
		final Quarto updateQuarto = quartoRepository.save(quarto);
		return updateQuarto;
	}

	  

}
