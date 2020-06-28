package org.br.poorbnb.poorbnb.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the tb_cobranca_hotel database table.
 * 
 */

@Data
@Entity
@Table(name="tb_cobranca_hotel")
public class CobrancaHotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="MAL_AVALIADO")
	private String malAvaliado;

	@Column(name="VALOR_DESCONTO")
	private BigDecimal valorDesconto;

	@Column(name="HIST_COBR")
	private Integer histCobr;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_HOTEL")
	private Hotel hotel;

	public CobrancaHotel() {
		super();
	}

	public CobrancaHotel(final Integer histCobr, final String malAvaliado) {
		this.histCobr = histCobr;
		this.malAvaliado = malAvaliado;
	}
}