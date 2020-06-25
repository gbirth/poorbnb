package org.br.poorbnb.poorbnb.model;

import org.br.poorbnb.poorbnb.model.pk.AvaliacaoUsuarioPK;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the avaliacao_usuario database table.
 * 
 */
@Entity
@Table(name="avaliacao_usuario")
@NamedQuery(name="AvaliacaoUsuario.findAll", query="SELECT a FROM AvaliacaoUsuario a")
public class AvaliacaoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AvaliacaoUsuarioPK id;

	@Column(name="ID_RESERVA")
	private int idReserva;

	@Column(name="NOTA_USUARIO")
	private double notaUsuario;

	public AvaliacaoUsuario() {
	}

	public AvaliacaoUsuarioPK getId() {
		return this.id;
	}

	public void setId(AvaliacaoUsuarioPK id) {
		this.id = id;
	}

	public int getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public double getNotaUsuario() {
		return this.notaUsuario;
	}

	public void setNotaUsuario(double notaUsuario) {
		this.notaUsuario = notaUsuario;
	}

}