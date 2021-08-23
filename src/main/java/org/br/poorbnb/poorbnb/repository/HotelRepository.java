package org.br.poorbnb.poorbnb.repository;

import org.br.poorbnb.poorbnb.constant.HotelConstants;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query(" select hot from Hotel hot "
            + " inner join hot.cobrancaHotel ch "
            + "     where ch.histCobr = (select max(hc.histCobr) from CobrancaHotel hc "
            + "                               where hc.idHotel = ch.idHotel) "
            + "     and (hot.desativadoSN = '" + HotelConstants.NAO + "'"
            + "     or hot.desativadoSN is null)     "
            + "     and (:nomeHotel is null or       "
            + "     hot.nomeHotel like :nomeHotel%)"
            + "     order by ch.malAvaliado ")
    List<Hotel> obterHoteisSimilaresPorNome(@Param("nomeHotel") String nomeHotel);
}
