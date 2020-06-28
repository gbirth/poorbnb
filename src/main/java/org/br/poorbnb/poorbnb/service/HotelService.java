package org.br.poorbnb.poorbnb.service;

import org.br.poorbnb.poorbnb.model.Hotel;

import java.util.List;


public interface HotelService {

    Hotel inserirHotel(Hotel hotel);

    void removerHotel(Hotel hotel);

    List<Hotel> verificarAvaliacao();

    List<Hotel> listarHoteis(String nomeHotel);
}
