package org.br.poorbnb.poorbnb.pattern.strategy;

@FunctionalInterface
public interface AvaliacaoStrategy <T> {
    Double calcularAvaliacao(T user);
}
