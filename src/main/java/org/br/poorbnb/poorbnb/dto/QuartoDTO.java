package org.br.poorbnb.poorbnb.dto;

import lombok.Data;
import org.br.poorbnb.poorbnb.vo.QuartoVO;

import javax.management.AttributeNotFoundException;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class QuartoDTO implements Serializable {

    private String descricao;
    private String ocupadoSN;
    private BigDecimal preco;

    public QuartoVO paraVO() throws AttributeNotFoundException {
        return new QuartoVO(
                this.descricao,
                this.ocupadoSN,
                this.preco
        );
    }
}
