package org.br.poorbnb.poorbnb.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * The primary key class for the avaliacao_hotel database table.
 * 
 */
@Embeddable
@Data
public class AvaliacaoHotelPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL_AVALIADO", updatable=false)
	private Long idHotelAvaliado;

	@Column(name="ID_AVALIADOR", updatable=false)
	private Long idAvaliador;

}