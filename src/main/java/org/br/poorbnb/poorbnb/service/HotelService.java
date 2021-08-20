package org.br.poorbnb.poorbnb.service;

import org.br.poorbnb.poorbnb.dto.HotelDTO;
import org.br.poorbnb.poorbnb.model.Hotel;

import java.util.List;
import java.util.Map;


public interface HotelService {

    Hotel inserirHotel(HotelDTO hotel);

    void publicarEvento(final Hotel hotel);

    void removerHotel(Hotel hotel);

    List<Hotel> obterHoteis();

    Map<Hotel, Double> obterAvaliacoes();

    List<Hotel> reverPrivilegiosHoteis(final Map<Hotel, Double> hotel);

    List<HotelDTO> obterHoteisSimilaresPorNome(String nomeHotel);
}
