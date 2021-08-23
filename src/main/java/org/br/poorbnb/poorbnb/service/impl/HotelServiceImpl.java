package org.br.poorbnb.poorbnb.service.impl;

import org.br.poorbnb.poorbnb.dto.HotelDTO;
import org.br.poorbnb.poorbnb.event.AppEvent;

import org.br.poorbnb.poorbnb.pattern.strategy.UsuarioEnum;
import org.br.poorbnb.poorbnb.pattern.command.Condicao;
import org.br.poorbnb.poorbnb.pattern.command.Handler;
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

    private HotelRepository hotelRepository;
    private AvaliacaoHotelService avaliacaoHotelService;
    private CobrancaHotelService cobrancaHotelService;
    private ApplicationEventPublisher applicationEventPublisher;
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
    public void removerHotel(Hotel hotel) {
        hotel.setDesativadoSN(HotelConstants.SIM);
        this.hotelRepository.saveAndFlush(hotel);
    }

    @Override
    public Map<Hotel, Double> obterAvaliacoes() {
        final List<Hotel> hoteis = this.obterTodosHoteis();

        return hoteis
                .stream()
                .map(hotel -> {
                    final Double mediaAvaliacao = UsuarioEnum.HOTEL.calcularAvaliacao(hotel, this.avaliacaoHotelService);
                    return Map.of(hotel, mediaAvaliacao);
                })
                .flatMap(hotelMapStream ->
                        hotelMapStream
                        .entrySet()
                        .stream())
                .collect(
                        Collectors
                                .toMap(Map.Entry::getKey,
                                       Map.Entry::getValue,
                                       (original, repetido) -> (original * repetido) / 2));
    }

    @Override
    public List<HotelDTO> reverPrivilegiosHoteis(final Map<Hotel, Double> avaliacoesHoteis) {
        return avaliacoesHoteis.entrySet()
                .stream()
                .reduce(Collections.emptyList(), (hoteisRevistos, hotelAtual) -> {
                    final Hotel hotel = hotelAtual.getKey();
                    final Double avaliacao = hotelAtual.getValue();

                    final Handler handler = encontrarHandler(commands, avaliacao);
                    handler.executar(hotel);

                    final HotelDTO build = HotelDTO.builder()
                            .nomeHotel(hotel.getNomeHotel())
                            .mediaAvaliacao(avaliacao)
                            .build();

                    hoteisRevistos.add(build);
                    return hoteisRevistos;
        }, (hoteis, hoteisRepetidos) -> {
                    hoteis.addAll(hoteisRepetidos);
                    return hoteis;
                });

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
        final Optional<Condicao> handler = commander.keySet()
                .stream()
                .filter(chave -> chave.validadorCondicao(mediaAvaliacao))
                .findFirst();

        return commander.get(handler.get());
    }

    private Map<Condicao, Handler> obterHotelCommander() {
        return Map.ofEntries(
                new AbstractMap.SimpleEntry<Condicao, Handler>((r) -> r >= HotelConstants.QUATRO_E_MEIO,
                        (h) -> cobrancaHotelService.conceberDesconto(h)),
                new AbstractMap.SimpleEntry<Condicao, Handler>((r) -> r >= HotelConstants.TRES && r < HotelConstants.QUATRO_E_MEIO,
                        (h) -> cobrancaHotelService.manterEstavelOuRemoverRestricao(h)),
                new AbstractMap.SimpleEntry<Condicao, Handler>((r) -> r >= HotelConstants.UM && r < HotelConstants.TRES,
                        (h) -> cobrancaHotelService.aplicarRestricaoPesquisa(h)),
                new AbstractMap.SimpleEntry<Condicao, Handler>((r) -> r < HotelConstants.UM, (h) -> removerHotel(h))
        );
    }

}