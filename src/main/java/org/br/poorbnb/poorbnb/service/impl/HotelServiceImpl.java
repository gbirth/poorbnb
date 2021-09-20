package org.br.poorbnb.poorbnb.service.impl;

import org.br.poorbnb.poorbnb.command.HotelAvaliacaoFactory;
import org.br.poorbnb.poorbnb.dto.AvaliacaoHotelDTO;
import org.br.poorbnb.poorbnb.dto.HotelDTO;
import org.br.poorbnb.poorbnb.event.AppEvent;

import org.br.poorbnb.poorbnb.model.CobrancaHotel;
import org.br.poorbnb.poorbnb.strategy.UsuarioEnum;
import org.br.poorbnb.poorbnb.constant.HotelConstants;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.repository.HotelRepository;
import org.br.poorbnb.poorbnb.service.AvaliacaoHotelService;
import org.br.poorbnb.poorbnb.service.HotelService;
import org.br.poorbnb.poorbnb.vo.HotelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final AvaliacaoHotelService avaliacaoHotelService;
    private final HotelAvaliacaoFactory hotelAvaliacaoFactory;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public HotelServiceImpl(HotelRepository repository,
                            AvaliacaoHotelService avaliacaoHotelService,
                            HotelAvaliacaoFactory hotelAvaliacaoFactory,
                            ApplicationEventPublisher applicationEventPublisher) {
        this.hotelRepository = repository;
        this.avaliacaoHotelService = avaliacaoHotelService;
        this.hotelAvaliacaoFactory = hotelAvaliacaoFactory;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public Hotel inserirHotel(final HotelVO hotel) {
        final Hotel entidade = hotel.paraEntidade();
        return this.hotelRepository.save(entidade);
    }

    @Override
    public void publicarEventoHotelInserido(Hotel hotel) {
        this.applicationEventPublisher.publishEvent(new AppEvent(hotel));
    }

    @Override
    public List<AvaliacaoHotelDTO> obterAvaliacoes() {
        final List<Hotel> hoteis = this.obterTodosHoteis();

        return hoteis.stream()
                .map(hotel -> {
                    final Double mediaAvaliacao = UsuarioEnum.HOTEL.calcularAvaliacao(hotel, this.avaliacaoHotelService);
                    return new AvaliacaoHotelDTO(hotel, mediaAvaliacao);
                }).collect(Collectors.toList());
    }

    @Override
    public List<HotelDTO> reverPrivilegiosHoteis(final List<AvaliacaoHotelDTO> avaliacoesHoteis) {
        return avaliacoesHoteis
                .stream()
                .map(avaliacaoHotelDTO -> {
                    final Hotel hotel = avaliacaoHotelDTO.getHotel();
                    final Double avaliacao = avaliacaoHotelDTO.getAvaliacao();

                    aplicarPoliticaAvaliacaoHotel(avaliacao, hotel);

                    return HotelDTO.builder()
                            .nomeHotel(hotel.getNomeHotel())
                            .mediaAvaliacao(avaliacao)
                            .build();
                }).collect(Collectors.toList());
    }

    @Override
    public List<Hotel> obterTodosHoteis() {
        return this.hotelRepository.findAll();
    }

    @Override
    public List<Hotel> obterHoteisSimilaresPorNome(String nomeHotel) {
        return this.hotelRepository.obterHoteisSimilaresPorNome(nomeHotel);
    }

    private CobrancaHotel aplicarPoliticaAvaliacaoHotel(final Double avaliacao, final Hotel hotel) {
        if (avaliacao < HotelConstants.UM) {
            this.removerHotel(hotel);
            return new CobrancaHotel();
        } else {
            return this.hotelAvaliacaoFactory.aplicaPoliticaAvaliacao(avaliacao, hotel);
        }
    }

    @Override
    public void removerHotel(Hotel hotel) {
        hotel.setDesativadoSN(HotelConstants.SIM);
        this.hotelRepository.saveAndFlush(hotel);
    }

}