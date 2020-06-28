package org.br.poorbnb.poorbnb.model;

import java.io.Serializable;

import javax.persistence.*;

import org.br.poorbnb.poorbnb.model.pk.AvaliacaoHotelPK;

import lombok.Data;

/**
 * The persistent class for the avaliacao_hotel database table.
 * 
 */
@Entity
@Table(name = "avaliacao_hotel")
@Data
public class AvaliacaoHotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AvaliacaoHotelPK id;

	@Column(name = "ID_RESERVA")
	private Long idReserva;

	@Column(name = "NOTA_HOTEL")
	private Double notaHotel;

	// bi-directional many-to-one association to Usuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AVALIADOR", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)
	private Usuario usuario;

	// bi-directional many-to-one association to Hotel
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_HOTEL_AVALIADO", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false)
	private Hotel hotel;

}