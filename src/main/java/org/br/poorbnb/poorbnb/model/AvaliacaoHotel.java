package org.br.poorbnb.poorbnb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.br.poorbnb.poorbnb.model.pk.AvaliacaoHotelPK;

import lombok.Data;

/**
 * The persistent class for the avaliacao_hotel database table.
 * 
 */
@Entity
@Table(name = "avaliacao_hotel")
@NamedQuery(name = "AvaliacaoHotel.findAll", query = "SELECT a FROM AvaliacaoHotel a")
@Data
public class AvaliacaoHotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AvaliacaoHotelPK id;

	@Column(name = "ID_RESERVA")
	private Long idReserva;

	@Column(name = "NOTA_HOTEL")
	private double notaHotel;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "ID_AVALIADOR", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)
	private Usuario usuario;

	// bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name = "ID_HOTEL_AVALIADO", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false)
	private Hotel hotel;

}