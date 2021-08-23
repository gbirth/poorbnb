package org.br.poorbnb.poorbnb.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.br.poorbnb.poorbnb.vo.QuartoVO;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


/**
 * The persistent class for the QUARTO database table.
 * 
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "QUARTO")
public class Quarto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_QUARTO")
	private Long idQuarto;

	@Column(name="DESCRICAO")
	private String descricao;

	@Column(name="ID_RESERVA")
	private Long idReserva;

	@Column(name="OCUPADO_S_N")
	private String ocupadoSN;

	@Column(name="PRECO")
	private BigDecimal preco;

	//bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name="ID_HOTEL")
	private Hotel hotel;

	public Quarto(final QuartoVO valueObject, final Quarto entidade) {
		this.descricao = obterValorNaoNulo(entidade.getDescricao(), valueObject.getDescricao());
		this.ocupadoSN = obterValorNaoNulo(entidade.getOcupadoSN(), valueObject.getOcupadoSN());
		this.preco = obterValorNaoNulo(entidade.getPreco(), valueObject.getPreco());
	}

	private <T> T obterValorNaoNulo(T one, T two) {
		return Objects.isNull(two) ? one: two;
	}
}