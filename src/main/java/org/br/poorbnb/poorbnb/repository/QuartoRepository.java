package org.br.poorbnb.poorbnb.repository;

import org.br.poorbnb.poorbnb.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {
}
