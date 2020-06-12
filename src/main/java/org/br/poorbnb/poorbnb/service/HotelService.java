package org.br.poorbnb.poorbnb.service;

import org.br.poorbnb.poorbnb.dto.ResponseDTO;
import org.br.poorbnb.poorbnb.model.Hotel;


public interface HotelService {

    ResponseDTO insereHotel(Hotel hotel);
}
