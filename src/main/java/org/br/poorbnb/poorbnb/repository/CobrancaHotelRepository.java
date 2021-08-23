package org.br.poorbnb.poorbnb.repository;

import org.br.poorbnb.poorbnb.model.CobrancaHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CobrancaHotelRepository extends JpaRepository<CobrancaHotel, Long> {


    @Query(" from CobrancaHotel as ch   "
            + "       inner join ch.hotel as hot"
            + "       where ch.idHotel = :id    "
            + "       order by ch.histCobr desc ")
    List<CobrancaHotel> obterUltimaCobrancaHotel(@Param("id") Long id);
}
