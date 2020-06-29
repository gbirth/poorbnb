package org.br.poorbnb.poorbnb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="DT_ENTRADA")
	private Date dtEntrada;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="DT_SAIDA")
	private Date dtSaida;

	@Column(name="TOTAL_RESERVA")
	private BigDecimal totalReserva;

	//bi-directional many-to-one association to Hotel
	@JsonBackReference(value = "hotel-reference")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name="ID_HOTEL")
	private Hotel hotel;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JsonBackReference(value = "user-reference")
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;


}