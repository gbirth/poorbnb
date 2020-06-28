package org.br.poorbnb.poorbnb.model.pk;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the avaliacao_usuario database table.
 * 
 */
@Data
@Embeddable
public class AvaliacaoUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO_AVALIADO", insertable=false, updatable=false)
	private Integer idUsuarioAvaliado;

	@Column(name="ID_AVALIADOR", insertable=false, updatable=false)
	private Integer idAvaliador;

}