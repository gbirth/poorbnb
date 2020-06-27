package org.br.poorbnb.poorbnb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_HOTEL")
	private Long idHotel;

	@NotEmpty
	@Column(name="ENDERECO")
	private String endereco;

	@NotEmpty
	@Column(name="NOME_HOTEL")
	private String nomeHotel;

	@NotEmpty
	@Column(name="TELEFONE")
	private String telefone;

	@Column(name="TELEFONE_OPC")
	private String telefoneOpc;

	@Column(name="DESATIVADO_S_N")
	private String desativadoSN;

	//bi-directional many-to-one association to Usuario
	@Cascade(CascadeType.ALL)
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

	@OneToOne(mappedBy = "hotel")
	private CobrancaHotel cobrancaHotel;
}