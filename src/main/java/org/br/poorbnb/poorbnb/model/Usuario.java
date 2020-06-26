package org.br.poorbnb.poorbnb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;

import lombok.Data;


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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_USUARIO")
	private Long idUsuario;

	@Max(value = 15, message = "O valor máximo do campo é 15")
	@Column(name="CPF_CNPJ")
	private Long cpfCnpj;

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