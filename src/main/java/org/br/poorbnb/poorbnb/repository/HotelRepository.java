package org.br.poorbnb.poorbnb.repository;

import org.br.poorbnb.poorbnb.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
