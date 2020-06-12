package org.br.poorbnb.poorbnb.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO {

    private String mensagem;
    private Integer httpStatus;

    public ResponseDTO(final String mensagem, final Integer httpStatus) {
        this.mensagem = mensagem;
        this.httpStatus = httpStatus;
    }

}
