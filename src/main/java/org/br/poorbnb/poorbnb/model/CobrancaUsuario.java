package org.br.poorbnb.poorbnb.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the tb_cobranca_usuario database table.
 * 
 */

@Data
@Entity
@Table(name="tb_cobranca_usuario")
public class CobrancaUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	private Long idUsuario;

	@Column(name="VALOR_DESCONTO")
	private BigDecimal valorDesconto;

	@Column(name="HIST_COBR")
	private Integer histCobr;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	public CobrancaUsuario() {
		super();
	}

}