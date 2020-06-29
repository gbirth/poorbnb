package org.br.poorbnb.poorbnb.controller;

import org.br.poorbnb.poorbnb.dto.ReservaDTO;
import org.br.poorbnb.poorbnb.model.Reserva;
import org.br.poorbnb.poorbnb.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/reserva")
public class ControllerReserva {

    private ReservaService reservaService;

    @Autowired
    public ControllerReserva(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<Reserva> criarReserva(@Valid @RequestBody ReservaDTO reserva) {
        return new ResponseEntity<>(this.reservaService.inserirReserva(reserva), HttpStatus.CREATED);
    }

    @GetMapping("/reservas-por-id")
    public ResponseEntity<List<Reserva>> fetchReserva(@RequestParam Long idUsuario) {
        return ResponseEntity.ok(this.reservaService.encontrarReservaPorIdUsuario(idUsuario));
    }

    @PutMapping
    public ResponseEntity<Reserva> ajustarReserva(@Valid @RequestBody ReservaDTO reservaDTO) {
        return ResponseEntity.ok(this.reservaService.atualizarReserva(reservaDTO));
    }
}
