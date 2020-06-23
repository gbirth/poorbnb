package org.br.poorbnb.poorbnb.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SERVICO database table.
 * 
 */
@Entity
@Data
@Table(name="SERVICO")
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_SERVICO")
	private Long idServico;

	@Column(name="DISPONIVEL_S_N")
	private String disponivelSN;

	@Column(name="NOME_SERVICO")
	private String nomeServico;

	@Column(name="PRECO")
	private BigDecimal preco;

	//bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name="ID_HOTEL")
	private Hotel hotel;

}