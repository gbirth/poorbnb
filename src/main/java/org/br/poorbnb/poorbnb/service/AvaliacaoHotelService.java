package org.br.poorbnb.poorbnb.service;

import org.br.poorbnb.poorbnb.model.AvaliacaoHotel;

import java.util.List;

public interface AvaliacaoHotelService {

    AvaliacaoHotel regristrarAvaliacaoHotel(AvaliacaoHotel avaliacaoHotel);

    List<AvaliacaoHotel> listarAvaliacoesHotel(Long id);
}
