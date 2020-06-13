package org.br.poorbnb.poorbnb.service.impl;

import org.br.poorbnb.poorbnb.any.strategy.UsuarioEnum;
import org.br.poorbnb.poorbnb.any.command.Condition;
import org.br.poorbnb.poorbnb.any.command.Handler;
import org.br.poorbnb.poorbnb.any.command.HotelCommand;
import org.br.poorbnb.poorbnb.constant.HotelConstants;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.repository.HotelRepository;
import org.br.poorbnb.poorbnb.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;
    private HotelCommand hotelCommand;

    @Autowired
    public HotelServiceImpl(HotelRepository repository, HotelCommand hotelCommand) {
        this.hotelRepository = repository;
        this.hotelCommand = hotelCommand;
    }

    @Override
    public Hotel inserirHotel(Hotel hotel) {
      return this.hotelRepository.save(hotel);
    }

    @Override
    public void removerHotel(Hotel hotel) {
      this.hotelRepository.delete(hotel);
    }

    @Override
    public List<Hotel> verificarAvaliacao() {
        final List<Hotel> hoteis = this.hotelRepository.findAll();
        final List<Hotel> reviwed = new ArrayList<>();

        hoteis.forEach(hotel -> {
            final Double rateAverage = UsuarioEnum.HOTEL.calcularAvaliacao(hotel);
            final Map<Condition, Handler> commanderOfHotel = this.hotelCommand.getCommanderOfHotel(hotel);
            findCondtion(commanderOfHotel, rateAverage);

            if (rateAverage >= HotelConstants.THREE && rateAverage < HotelConstants.FOUR_AND_HALF) {
                reviwed.add(hotel);
            }
        });

        return reviwed;
    }

    private void findCondtion(final Map<Condition, Handler> commanderOfHotel, final Double rateAverage) {
        final Optional<Condition> first = commanderOfHotel.keySet()
                .stream()
                .filter(any -> any.conditionChecker(rateAverage))
                .findFirst();

        commanderOfHotel.get(first.get()).handler();
    }

}
