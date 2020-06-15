package org.br.poorbnb.poorbnb.controller;

import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/hotel")
public class ControllerHotel {

    private HotelService hotelService;

    @Autowired
    ControllerHotel(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<Hotel> criarHotel(@Valid @RequestBody Hotel hotel) {
        return ResponseEntity.ok(this.hotelService.inserirHotel(hotel));
    }

    @PutMapping("/must-pay-more-or-less")
    public ResponseEntity<List<Hotel>> verificarAvaliacoes() {
        return ResponseEntity.ok(this.hotelService.verificarAvaliacao());
    }
}
