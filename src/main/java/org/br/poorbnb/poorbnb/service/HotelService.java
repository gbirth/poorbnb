package org.br.poorbnb.poorbnb.service;

import org.br.poorbnb.poorbnb.dto.AvaliacaoHotelDTO;
import org.br.poorbnb.poorbnb.dto.HotelDTO;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.vo.HotelVO;

import java.util.List;


public interface HotelService {

    Hotel inserirHotel(HotelVO hotel);

    void publicarEventoHotelInserido(final Hotel hotel);

    void removerHotel(Hotel hotel);

    List<Hotel> obterTodosHoteis();

    List<AvaliacaoHotelDTO> obterAvaliacoes();

    List<HotelDTO> reverPrivilegiosHoteis(final List<AvaliacaoHotelDTO> avaliacoesHotel);

    List<Hotel> obterHoteisSimilaresPorNome(String nomeHotel);
}
