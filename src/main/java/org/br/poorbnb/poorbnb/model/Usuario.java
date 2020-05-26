package org.br.poorbnb.poorbnb.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@Data
@Table(name="USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SQ_ID_USUARIO", allocationSize = 1, sequenceName="SQ_ID_USUARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_ID_USUARIO")
	@Column(name="ID_USUARIO")
	private long idUsuario;

	@Column(name="CPF_CNPJ")
	private BigDecimal cpfCnpj;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_NASC")
	private Date dtNasc;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_REGISTRO")
	private Date dtRegistro;

	@Column(name="EMAIL")
	private String email;

	@Column(name="ENDERECO")
	private String endereco;

	@Column(name="NOME")
	private String nome;

	@Column(name="SENHA")
	private String senha;

	@Column(name="TELEFONE")
	private String telefone;

	@Column(name="TIPO_USUARIO")
	private String tipoUsuario;

	//bi-directional many-to-one association to Hotel
	@OneToMany(mappedBy="usuario")
	private List<Hotel> hotels;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="usuario")
	private List<Reserva> reservas;

}