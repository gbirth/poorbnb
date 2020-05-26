package org.br.poorbnb.poorbnb.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


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
	@SequenceGenerator(name="SQ_ID_QUARTO", allocationSize = 1, sequenceName="SQ_ID_QUARTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_ID_QUARTO")
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