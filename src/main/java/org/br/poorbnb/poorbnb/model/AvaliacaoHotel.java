package org.br.poorbnb.poorbnb.model;

import org.br.poorbnb.poorbnb.model.pk.AvaliacaoHotelPK;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the avaliacao_hotel database table.
 * 
 */
@Entity
@Table(name="avaliacao_hotel")

public class AvaliacaoHotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AvaliacaoHotelPK id;

	@NotNull(message = "Não é possível avaliar um hotel sem referencia-lo")
	@Column(name="ID_RESERVA")
	private Long idReserva;

	@NotNull
	@Column(name="NOTA_HOTEL")
	private Double notaHotel;

	public AvaliacaoHotel() {
	}

	public AvaliacaoHotelPK getId() {
		return this.id;
	}

	public void setId(AvaliacaoHotelPK id) {
		this.id = id;
	}

	public Long getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public Double getNotaHotel() {
		return this.notaHotel;
	}

	public void setNotaHotel(Double notaHotel) {
		this.notaHotel = notaHotel;
	}

}