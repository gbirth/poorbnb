package org.br.poorbnb.poorbnb.repository;

import java.util.List;

import org.br.poorbnb.poorbnb.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {
//	@Query("SELECT q FROM Quarto q WHERE q.OCUPADO_S_N = ?1")
//	   List<Quarto> buscarQuartoPorStatus(@Param("S") String s);
}
