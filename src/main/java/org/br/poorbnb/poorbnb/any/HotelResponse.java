package org.br.poorbnb.poorbnb.any;

import org.springframework.http.HttpStatus;

public enum HotelResponse {

    SUCESSO("Sucesso ao realizar a operação!", HttpStatus.CREATED),
    ERRO_INSERIR_HOTEL("Erro ao inserir Hotel", HttpStatus.NOT_ACCEPTABLE);

    private final String mensagem;
    private final HttpStatus httpStatus;

    HotelResponse(String mensagem, HttpStatus httpStatus) {
        this.mensagem = mensagem;
        this.httpStatus = httpStatus;
    }

    public String getMensagem() {
        return mensagem;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
