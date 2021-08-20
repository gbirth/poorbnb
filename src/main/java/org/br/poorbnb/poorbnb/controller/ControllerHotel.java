package org.br.poorbnb.poorbnb.controller;

import org.br.poorbnb.poorbnb.dto.HotelDTO;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/hotel")
public class ControllerHotel {

    private HotelService hotelService;

    @Autowired
    ControllerHotel(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<Hotel> criarHotel(@Valid @RequestBody HotelDTO hotelDTO) {
        final Hotel hotel = this.hotelService.inserirHotel(hotelDTO);
        this.hotelService.publicarEvento(hotel);

        return ResponseEntity.ok(hotel);
    }

    @PutMapping("/must-pay-more-or-less")
    public ResponseEntity<List<Hotel>> verificarAvaliacoes() {
        final Map<Hotel, Double> hoteis = this.hotelService.obterAvaliacoes();
        final List<Hotel> hotelList = this.hotelService.reverPrivilegiosHoteis(hoteis);
        return ResponseEntity.ok(hotelList);
    }

    @GetMapping
    public ResponseEntity<List<HotelDTO>> listarHoteis(@RequestParam(required = false) String nomeHotel) {
        return ResponseEntity.ok(this.hotelService.obterHoteisSimilaresPorNome(nomeHotel));
    }
}
