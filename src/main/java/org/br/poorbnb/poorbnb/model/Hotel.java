package org.br.poorbnb.poorbnb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the HOTEL database table.
 * 
 */
@Entity
@Data
@Table(name = "HOTEL")
public class Hotel implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4474361041998773912L;

	@Id
	@SequenceGenerator(name="SQ_ID_HOTEL", allocationSize = 1, sequenceName="SQ_ID_HOTEL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_ID_HOTEL")
	@Column(name="ID_HOTEL")
	private Long idHotel;
	
	@Column(name="ENDERECO")
	private String endereco;

	@Column(name="NOME_HOTEL")
	private String nomeHotel;

	@Column(name="TELEFONE")
	private String telefone;

	@Column(name="TELEFONE_OPC")
	private String telefoneOpc;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_PROPRIETARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to Quarto
	@OneToMany(mappedBy="hotel")
	private List<Quarto> quartos;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="hotel")
	private List<Reserva> reservas;

	//bi-directional many-to-one association to Servico
	@OneToMany(mappedBy="hotel")
	private List<Servico> servicos;

}