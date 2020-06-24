package org.br.poorbnb.poorbnb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.br.poorbnb.poorbnb.model.pk.AvaliacaoUsuarioPK;

import lombok.Data;

/**
 * The persistent class for the avaliacao_usuario database table.
 * 
 */
@Entity
@Table(name = "avaliacao_usuario")
@NamedQuery(name = "AvaliacaoUsuario.findAll", query = "SELECT a FROM AvaliacaoUsuario a")
@Data
public class AvaliacaoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AvaliacaoUsuarioPK id;

	@Column(name = "ID_RESERVA")
	private int idReserva;

	@Column(name = "NOTA_USUARIO")
	private double notaUsuario;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO_AVALIADO")
	private Usuario usuario1;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "ID_AVALIADOR")
	private Usuario usuario2;

}