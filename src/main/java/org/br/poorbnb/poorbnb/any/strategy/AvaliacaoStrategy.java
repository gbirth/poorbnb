package org.br.poorbnb.poorbnb.any.strategy;

@FunctionalInterface
public interface AvaliacaoStrategy <T> {
    Double calcularAvaliacao(T user);
}
