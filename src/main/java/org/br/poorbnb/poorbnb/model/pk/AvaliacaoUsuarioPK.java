package org.br.poorbnb.poorbnb.model.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the avaliacao_usuario database table.
 * 
 */
@Embeddable
public class AvaliacaoUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO_AVALIADO", insertable=false, updatable=false)
	private int idUsuarioAvaliado;

	@Column(name="ID_AVALIADOR", insertable=false, updatable=false)
	private int idAvaliador;

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AvaliacaoUsuarioPK)) {
			return false;
		}
		AvaliacaoUsuarioPK castOther = (AvaliacaoUsuarioPK)other;
		return 
			(this.idUsuarioAvaliado == castOther.idUsuarioAvaliado)
			&& (this.idAvaliador == castOther.idAvaliador);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsuarioAvaliado;
		hash = hash * prime + this.idAvaliador;
		
		return hash;
	}
}