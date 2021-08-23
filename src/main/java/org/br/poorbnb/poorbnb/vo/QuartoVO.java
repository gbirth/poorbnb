package org.br.poorbnb.poorbnb.vo;

import lombok.Getter;
import org.br.poorbnb.poorbnb.util.ValidationUtils;
import org.springframework.util.StringUtils;

import javax.management.AttributeNotFoundException;
import java.math.BigDecimal;

@Getter
public class QuartoVO {

    private String descricao;
    private String ocupadoSN;
    private BigDecimal preco;

    public QuartoVO(final String descricao,
                    final String ocupadoSN,
                    final BigDecimal preco) throws AttributeNotFoundException {

        this.preco = verificarPreco(preco);
        this.ocupadoSN = ValidationUtils.simOuNao(ocupadoSN);
        this.descricao = sanitizarDescricao(descricao);
    }

    private BigDecimal verificarPreco(final BigDecimal preco) throws AttributeNotFoundException {
        if (preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new AttributeNotFoundException("Valor informado inválido!");
        }
        return preco;
    }

    private String sanitizarDescricao(final String descricao) {
        if (StringUtils.hasText(descricao)) {
            return descricao.stripTrailing().toLowerCase();
        }
        return "";
    }
}
