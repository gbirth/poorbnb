package org.br.poorbnb.poorbnb.service.impl;

import org.br.poorbnb.poorbnb.model.AvaliacaoHotel;
import org.br.poorbnb.poorbnb.repository.AvaliacaoHotelRepository;
import org.br.poorbnb.poorbnb.service.AvaliacaoHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoHotelServiceImpl implements AvaliacaoHotelService {

    private AvaliacaoHotelRepository avaliacaoHotelRepository;

    @Autowired
    public AvaliacaoHotelServiceImpl(AvaliacaoHotelRepository avaliacaoHotelRepository) {
        this.avaliacaoHotelRepository = avaliacaoHotelRepository;
    }

    @Override
    public AvaliacaoHotel regristrarAvaliacaoHotel(AvaliacaoHotel avaliacaoHotel) {
        return this.avaliacaoHotelRepository.save(avaliacaoHotel);
    }

    @Override
    public List<AvaliacaoHotel> listarAvaliacoesHotel(Long id) {
        return this.avaliacaoHotelRepository.buscarAvaliacoesPorId(id);
    }
}
