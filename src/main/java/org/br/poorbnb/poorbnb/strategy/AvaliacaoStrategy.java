package org.br.poorbnb.poorbnb.strategy;

public interface AvaliacaoStrategy <T> {
    Double calcularAvaliacao(T user, T getAvaliacao);
}
