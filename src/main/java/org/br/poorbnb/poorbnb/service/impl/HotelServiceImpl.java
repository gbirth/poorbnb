package org.br.poorbnb.poorbnb.service.impl;

import org.br.poorbnb.poorbnb.dto.AvaliacaoHotelDTO;
import org.br.poorbnb.poorbnb.dto.HotelDTO;
import org.br.poorbnb.poorbnb.event.AppEvent;

import org.br.poorbnb.poorbnb.strategy.UsuarioEnum;
import org.br.poorbnb.poorbnb.command.Condicao;
import org.br.poorbnb.poorbnb.command.Handler;
import org.br.poorbnb.poorbnb.constant.HotelConstants;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.repository.HotelRepository;
import org.br.poorbnb.poorbnb.service.AvaliacaoHotelService;
import org.br.poorbnb.poorbnb.service.CobrancaHotelService;
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
    private final CobrancaHotelService cobrancaHotelService;
    private final ApplicationEventPublisher applicationEventPublisher;
    private static Map<Condicao, Handler> commands;


    @Autowired
    public HotelServiceImpl(HotelRepository repository,
                            AvaliacaoHotelService avaliacaoHotelService,
                            CobrancaHotelService cobrancaHotelService,
                            ApplicationEventPublisher applicationEventPublisher) {
        this.hotelRepository = repository;
        this.avaliacaoHotelService = avaliacaoHotelService;
        this.cobrancaHotelService = cobrancaHotelService;
        this.applicationEventPublisher = applicationEventPublisher;
        commands = this.obterHotelCommander();
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

                    final Handler handler = encontrarHandler(commands, avaliacao);
                    handler.executar(hotel);

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

    private Handler encontrarHandler(final Map<Condicao, Handler> commander, final Double mediaAvaliacao) {
        final Condicao handler = commander.keySet()
                .stream()
                .filter(chave -> chave.validarCondicao(mediaAvaliacao))
                .findFirst()
                .orElse(null);

        return commander.get(handler);
    }

    private Map<Condicao, Handler> obterHotelCommander() {
        return Map.ofEntries(
                new AbstractMap.SimpleEntry<Condicao, Handler>((r) -> r >= HotelConstants.QUATRO_E_MEIO,
                        cobrancaHotelService::conceberDesconto),
                new AbstractMap.SimpleEntry<Condicao, Handler>((r) -> r >= HotelConstants.TRES && r < HotelConstants.QUATRO_E_MEIO,
                        cobrancaHotelService::manterEstavelOuRemoverRestricao),
                new AbstractMap.SimpleEntry<Condicao, Handler>((r) -> r >= HotelConstants.UM && r < HotelConstants.TRES,
                        cobrancaHotelService::aplicarRestricaoPesquisa),
                new AbstractMap.SimpleEntry<Condicao, Handler>((r) -> r < HotelConstants.UM, this::removerHotel)
        );
    }

    @Override
    public void removerHotel(Hotel hotel) {
        hotel.setDesativadoSN(HotelConstants.SIM);
        this.hotelRepository.saveAndFlush(hotel);
    }

}