package org.br.poorbnb.poorbnb.service.impl;

import org.br.poorbnb.poorbnb.any.HotelResponse;
import org.br.poorbnb.poorbnb.dto.ResponseDTO;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.repository.HotelRepository;
import org.br.poorbnb.poorbnb.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository repository) {
        this.hotelRepository = repository;
    }

    @Override
    public ResponseDTO insereHotel(Hotel hotel) {
        try {
            this.hotelRepository.save(hotel);
            return new ResponseDTO(HotelResponse.SUCESSO.getMensagem(),
                    HotelResponse.SUCESSO.getHttpStatus().value());
        } catch (RuntimeException e) {
            return new ResponseDTO(HotelResponse.ERRO_INSERIR_HOTEL.getMensagem(),
                    HotelResponse.ERRO_INSERIR_HOTEL.getHttpStatus().value());
        }

    }

}
