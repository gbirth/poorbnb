package org.br.poorbnb.poorbnb.model;

import java.io.Serializable;

import javax.persistence.*;

import org.br.poorbnb.poorbnb.model.pk.AvaliacaoUsuarioPK;

import lombok.Data;

/**
 * The persistent class for the avaliacao_usuario database table.
 * 
 */
@Entity
@Table(name = "avaliacao_usuario")
@Data
public class AvaliacaoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AvaliacaoUsuarioPK id;

	@Column(name = "ID_RESERVA")
	private Integer idReserva;

	@Column(name = "NOTA_USUARIO")
	private Double notaUsuario;

	// bi-directional many-to-one association to Usuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO_AVALIADO",referencedColumnName = "ID_USUARIO", insertable=false, updatable=false)
	private Usuario usuario1;

	// bi-directional many-to-one association to Usuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AVALIADOR",referencedColumnName = "ID_USUARIO", insertable=false, updatable=false)
	private Usuario usuario2;

}