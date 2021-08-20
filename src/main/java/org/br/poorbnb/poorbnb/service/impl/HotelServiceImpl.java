package org.br.poorbnb.poorbnb.service.impl;

import org.br.poorbnb.poorbnb.dto.HotelDTO;
import org.br.poorbnb.poorbnb.event.AppEvent;
import org.br.poorbnb.poorbnb.mapper.HotelMapper;
import org.br.poorbnb.poorbnb.mapper.factory.MapperFactory;
import org.br.poorbnb.poorbnb.pattern.strategy.UsuarioEnum;
import org.br.poorbnb.poorbnb.pattern.command.Condition;
import org.br.poorbnb.poorbnb.pattern.command.Handler;
import org.br.poorbnb.poorbnb.constant.HotelConstants;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.repository.HotelRepository;
import org.br.poorbnb.poorbnb.service.AvaliacaoHotelService;
import org.br.poorbnb.poorbnb.service.CobrancaHotelService;
import org.br.poorbnb.poorbnb.service.HotelService;
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
    private static HotelMapper hotelMapper;
    private static Map<Condition, Handler> commands;


    @Autowired
    public HotelServiceImpl(HotelRepository repository,
                            AvaliacaoHotelService avaliacaoHotelService,
                            CobrancaHotelService cobrancaHotelService,
                            ApplicationEventPublisher applicationEventPublisher,
                            MapperFactory mapper) {
        this.hotelRepository = repository;
        this.avaliacaoHotelService = avaliacaoHotelService;
        this.cobrancaHotelService = cobrancaHotelService;
        this.applicationEventPublisher = applicationEventPublisher;
        hotelMapper = mapper.getMapper(HotelMapper.class);
        commands = this.getCommanderOfHotel();
    }

    @Override
    public Hotel inserirHotel(final HotelDTO hotel) {
        final Hotel entidade = this.converterDTOEntidade(hotel);
        return this.hotelRepository.save(entidade);
    }

    public Hotel converterDTOEntidade(final HotelDTO hotel) {
        return hotelMapper.dtoToEntity(hotel);
    }

//    public HotelDTO converterEntidadeDTO(final Hotel hotel) {
//        return hotelMapper.entityToDTO(hotel);
//    }

    @Override
    public void publicarEvento(Hotel hotel) {
        this.applicationEventPublisher.publishEvent(new AppEvent(hotel));
    }

    @Override
    public void removerHotel(Hotel hotel) {
        hotel.setDesativadoSN(HotelConstants.SIM);
        this.hotelRepository.saveAndFlush(hotel);
    }

    @Override
    public Map<Hotel, Double> obterAvaliacoes() {
        final List<Hotel> hoteis = this.obterHoteis();

        return hoteis
                .stream()
                .map(hotel -> {
                    final Double rate = UsuarioEnum.HOTEL.calcularAvaliacao(hotel, this.avaliacaoHotelService);
                    return Map.of(hotel, rate);
                })
                .flatMap(hotelDoubleMap ->
                        hotelDoubleMap
                        .entrySet()
                        .stream())
                .collect(
                        Collectors
                                .toMap(Map.Entry::getKey,
                                       Map.Entry::getValue,
                                       (original, repeated) -> (original * repeated) / 2));
    }

    @Override
    public List<Hotel> reverPrivilegiosHoteis(final Map<Hotel, Double> hoteis) {
        return hoteis.entrySet()
                .stream()
                .reduce(Collections.emptyList(), (hotels, hotel) -> {
                    final Hotel _hotel = hotel.getKey();
                    final Double avaliacao = hotel.getValue();

                    final Handler handler = findCondtion(commands, avaliacao);

                    handler.act(_hotel);

                    if (avaliacao >= HotelConstants.THREE && avaliacao < HotelConstants.FOUR_AND_HALF) {
                        hotels.add(_hotel);
                    }
                    return hotels;
        }, (hotels, hotels2) -> {
                    hotels.addAll(hotels2);
                    return hotels;
                });

    }

    @Override
    public List<Hotel> obterHoteis() {
        return this.hotelRepository.findAll();
    }

    @Override
    public List<HotelDTO> obterHoteisSimilaresPorNome(String nomeHotel) {
        final List<Hotel> hotels = this.hotelRepository.obterHoteisSimilaresPorNome(nomeHotel);
        return hotels.stream()
                .map(hotel -> hotelMapper.entityToDTO(hotel))
                .collect(Collectors.toList());
    }

    private Handler findCondtion(final Map<Condition, Handler> commanderOfHotel, final Double rateAverage) {
        final Optional<Condition> first = commanderOfHotel.keySet()
                .stream()
                .filter(any -> any.conditionChecker(rateAverage))
                .findFirst();

        return commanderOfHotel.get(first.get());
    }

    public Map<Condition, Handler> getCommanderOfHotel() {
        return Map.ofEntries(
                new AbstractMap.SimpleEntry<Condition, Handler>((r) -> r >= HotelConstants.FOUR_AND_HALF,
                        (h) -> cobrancaHotelService.conceberDesconto(h)),
                new AbstractMap.SimpleEntry<Condition, Handler>((r) -> r >= HotelConstants.THREE && r < HotelConstants.FOUR_AND_HALF,
                        (h) -> cobrancaHotelService.manterEstavelOuRemoverRestricao(h)),
                new AbstractMap.SimpleEntry<Condition, Handler>((r) -> r >= HotelConstants.ONE && r < HotelConstants.THREE,
                        (h) -> cobrancaHotelService.aplicarRestricaoPesquisa(h)),
                new AbstractMap.SimpleEntry<Condition, Handler>((r) -> r < HotelConstants.ONE, (h) -> removerHotel(h))
        );
    }
}