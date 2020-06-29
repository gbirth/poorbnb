package org.br.poorbnb.poorbnb.service.impl;

import org.br.poorbnb.poorbnb.dto.ReservaDTO;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.model.Reserva;
import org.br.poorbnb.poorbnb.model.Usuario;
import org.br.poorbnb.poorbnb.repository.ReservaRepository;
import org.br.poorbnb.poorbnb.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReservaServiceImpl implements ReservaService {

    private ReservaRepository reservaRepository;

    @Autowired
    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public Reserva inserirReserva(ReservaDTO reserva) {
        final Reserva res = criarReserva(reserva.getReserva(),
                reserva.getIdUsuario(), reserva.getIdHotel());
        return this.reservaRepository.save(res);
    }

    @Override
    public Reserva atualizarReserva(ReservaDTO reserva) {
        final Reserva res = criarReserva(reserva.getReserva(), reserva.getIdUsuario(),
                reserva.getIdHotel());
        return this.reservaRepository.save(res);
    }

    private Reserva criarReserva(Reserva reserva, Long idUsuario, Long idHotel) {
        final Reserva res = new Reserva();
        res.setCodReserva(this.reservaRepository.obterUltimoCodReserva());
        res.setDtEntrada(reserva.getDtEntrada());
        res.setTotalReserva(reserva.getTotalReserva());
        res.setDtSaida(reserva.getDtSaida());
        res.setUsuario(new Usuario(idUsuario));
        res.setHotel(new Hotel(idHotel));

        return res;
    }

    @Override
    public List<Reserva> encontrarReservaPorIdUsuario(Long usuId) {
        Objects.requireNonNull(usuId);
        return this.reservaRepository.listarReservasUsuario(usuId);
    }
}
