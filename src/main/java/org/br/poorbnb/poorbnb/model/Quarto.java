package org.br.poorbnb.poorbnb.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the QUARTO database table.
 * 
 */
@Entity
@Data
@Table(name = "QUARTO")
public class Quarto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_QUARTO")
	private Long idQuarto;

	@Column(name="DESCRICAO")
	private String descricao;

	@Column(name="ID_RESERVA")
	private Long idReserva;

	@Column(name="OCUPADO_S_N")
	private String ocupadoSN;
	
	@Column(name="PRECO")
	private BigDecimal preco;

	//bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name="ID_HOTEL")
	private Hotel hotel;

}