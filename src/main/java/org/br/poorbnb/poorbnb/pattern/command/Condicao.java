package org.br.poorbnb.poorbnb.pattern.command;

import java.util.Objects;

@FunctionalInterface
public interface Condicao {

    boolean condicao(Double rate);

    default boolean validadorCondicao(Double rate) {
        Objects.requireNonNull(rate);
        return condicao(rate);
    }
}
