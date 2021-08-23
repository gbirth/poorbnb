package org.br.poorbnb.poorbnb.pattern.strategy;

public interface AvaliacaoStrategy <T> {
    Double calcularAvaliacao(T user, T getAvaliacao);
}
