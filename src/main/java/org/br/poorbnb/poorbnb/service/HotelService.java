package org.br.poorbnb.poorbnb.service;

import org.br.poorbnb.poorbnb.dto.HotelDTO;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.vo.HotelVO;

import java.util.List;
import java.util.Map;


public interface HotelService {

    Hotel inserirHotel(HotelVO hotel);

    void publicarEventoHotelInserido(final Hotel hotel);

    void removerHotel(Hotel hotel);

    List<Hotel> obterTodosHoteis();

    Map<Hotel, Double> obterAvaliacoes();

    List<HotelDTO> reverPrivilegiosHoteis(final Map<Hotel, Double> hotel);

    List<Hotel> obterHoteisSimilaresPorNome(String nomeHotel);
}
