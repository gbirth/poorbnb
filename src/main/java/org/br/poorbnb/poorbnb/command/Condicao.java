package org.br.poorbnb.poorbnb.command;

import java.util.Objects;

@FunctionalInterface
public interface Condicao {

    boolean condicao(Double rate);

    default boolean validarCondicao(Double rate) {
        Objects.requireNonNull(rate);
        return condicao(rate);
    }
}
