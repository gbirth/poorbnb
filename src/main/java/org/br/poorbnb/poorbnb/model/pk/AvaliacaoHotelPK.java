package org.br.poorbnb.poorbnb.model.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the avaliacao_hotel database table.
 * 
 */
@Embeddable
public class AvaliacaoHotelPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL_AVALIADO", insertable=false, updatable=false)
	private int idHotelAvaliado;

	@Column(name="ID_AVALIADOR")
	private int idAvaliador;

	public AvaliacaoHotelPK() {
	}
	public int getIdHotelAvaliado() {
		return this.idHotelAvaliado;
	}
	public void setIdHotelAvaliado(int idHotelAvaliado) {
		this.idHotelAvaliado = idHotelAvaliado;
	}
	public int getIdAvaliador() {
		return this.idAvaliador;
	}
	public void setIdAvaliador(int idAvaliador) {
		this.idAvaliador = idAvaliador;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AvaliacaoHotelPK)) {
			return false;
		}
		AvaliacaoHotelPK castOther = (AvaliacaoHotelPK)other;
		return 
			(this.idHotelAvaliado == castOther.idHotelAvaliado)
			&& (this.idAvaliador == castOther.idAvaliador);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idHotelAvaliado;
		hash = hash * prime + this.idAvaliador;
		
		return hash;
	}
}