package org.br.poorbnb.poorbnb.controller;

import org.br.poorbnb.poorbnb.dto.AvaliacaoHotelDTO;
import org.br.poorbnb.poorbnb.model.AvaliacaoHotel;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.service.AvaliacaoHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/avaliacao-hotel")
public class AvaliacaoHotelController {

    private AvaliacaoHotelService avaliacaoHotelService;

    @Autowired
    public AvaliacaoHotelController(AvaliacaoHotelService avaliacaoHotelService) {
        this.avaliacaoHotelService = avaliacaoHotelService;
    }

    @PostMapping
    public ResponseEntity<AvaliacaoHotel> registrarAvaliacao(@Valid @RequestBody AvaliacaoHotelDTO avaliacaoHotel) {
        return ResponseEntity.ok(this.avaliacaoHotelService.regristrarAvaliacaoHotel(avaliacaoHotel));
    }

}
