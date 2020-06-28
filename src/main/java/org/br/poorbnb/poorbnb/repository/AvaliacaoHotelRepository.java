package org.br.poorbnb.poorbnb.repository;

import org.br.poorbnb.poorbnb.model.AvaliacaoHotel;
import org.br.poorbnb.poorbnb.model.pk.AvaliacaoHotelPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AvaliacaoHotelRepository extends JpaRepository<AvaliacaoHotel, AvaliacaoHotelPK> {

   @Query("select ah from AvaliacaoHotel ah "
           +"    inner join ah.hotel hot    "
           +"    where hot.idHotel = :id    ")
   List<AvaliacaoHotel> buscarAvaliacoesPorId(@Param("id") Long id);
}
