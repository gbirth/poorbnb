package org.br.poorbnb.poorbnb.controller;

import org.br.poorbnb.poorbnb.dto.AvaliacaoHotelDTO;
import org.br.poorbnb.poorbnb.dto.HotelDTO;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
public class ControllerHotel {

    private HotelService hotelService;

    @Autowired
    public ControllerHotel(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<Hotel> criarHotel(@Valid @RequestBody HotelDTO hotelDTO)
            throws AttributeNotFoundException {
        final Hotel hotel = this.hotelService.inserirHotel(hotelDTO.paraVO());
        this.hotelService.publicarEventoHotelInserido(hotel);//Cobranças

        return ResponseEntity.ok(hotel);
    }

    @PutMapping
    public ResponseEntity<List<HotelDTO>> verificarAvaliacoes() {
        final List<AvaliacaoHotelDTO> avaliacoesHotel = this.hotelService.obterAvaliacoes();
        final List<HotelDTO> hoteisRevistos = this.hotelService.reverPrivilegiosHoteis(avaliacoesHotel);

        return ResponseEntity.ok(hoteisRevistos);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> listarHoteis(@RequestParam(required = false) String nomeHotel) {
        return ResponseEntity.ok(this.hotelService.obterHoteisSimilaresPorNome(nomeHotel));
    }
}
