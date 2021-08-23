package org.br.poorbnb.poorbnb.service.impl;

import org.br.poorbnb.poorbnb.dto.QuartoDTO;
import org.br.poorbnb.poorbnb.exception.ResourceNotFoundException;
import org.br.poorbnb.poorbnb.model.Quarto;
import org.br.poorbnb.poorbnb.repository.QuartoRepository;
import org.br.poorbnb.poorbnb.service.QuartoService;
import org.br.poorbnb.poorbnb.vo.QuartoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.AttributeNotFoundException;


@Service
public class QuartoServiceImpl implements QuartoService {

	private QuartoRepository quartoRepository;

	@Autowired
	public QuartoServiceImpl(QuartoRepository quartoRepository) {
		this.quartoRepository = quartoRepository;
	}


	public Quarto atualizaQuarto(Long quartoId, QuartoDTO quartoAlteracoes)
			throws ResourceNotFoundException, AttributeNotFoundException {

		final Quarto quarto = this.obterQuartoPorId(quartoId);
		final QuartoVO quartoVO = quartoAlteracoes.paraVO();
		final Quarto entidadeAtualizada = new Quarto(quartoVO, quarto);
		return quartoRepository.save(entidadeAtualizada);
	}

	@Override
	public Quarto obterQuartoPorId(Long quartoId) throws ResourceNotFoundException {
		final Quarto quarto = this.quartoRepository.findById(quartoId)
				.orElseThrow(ResourceNotFoundException::new);
		return quarto;
	}

	@Override
	public Quarto salvarQuarto(Quarto quarto) {
		return quartoRepository.save(quarto);
	}

}
