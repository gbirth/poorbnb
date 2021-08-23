package org.br.poorbnb.poorbnb.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the RESERVA database table.
 * 
 */
@Entity
@Data
@Table(name="RESERVA")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_RESERVA")
	private Long codReserva;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_ENTRADA")
	private Date dtEntrada;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_SAIDA")
	private Date dtSaida;

	@Column(name="TOTAL_RESERVA")
	private BigDecimal totalReserva;

	//bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name="ID_HOTEL")
	private Hotel hotel;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

}