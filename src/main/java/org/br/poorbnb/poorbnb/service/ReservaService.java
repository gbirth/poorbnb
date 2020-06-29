package org.br.poorbnb.poorbnb.service;

import org.br.poorbnb.poorbnb.dto.ReservaDTO;
import org.br.poorbnb.poorbnb.model.Reserva;

import java.util.List;

public interface ReservaService {

   Reserva inserirReserva(ReservaDTO reserva);
   Reserva atualizarReserva(ReservaDTO reserva);
   List<Reserva> encontrarReservaPorIdUsuario(Long usuId);
}
