package org.br.poorbnb.poorbnb.controller;

import org.br.poorbnb.poorbnb.dto.ResponseDTO;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/hotel")
public class ControllerHotel {

    private HotelService hotelService;

    @Autowired
    ControllerHotel(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseDTO criarHotel(@Valid @RequestBody Hotel hotel) {
        return this.hotelService.insereHotel(hotel);
    }
}
