package org.br.poorbnb.poorbnb.repository;

import org.br.poorbnb.poorbnb.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Long> {

    @Query(" from Reserva rs " +
            "   where rs.usuario.idUsuario = ?1" +
            "   order by rs.codReserva desc")
    List<Reserva> listarReservasUsuario(Long id);

    @Query("select coalesce( "
           + "(select max(rs.codReserva) from Reserva rs), 0) + 1 from Reserva r")
    Long obterUltimoCodReserva();
}
