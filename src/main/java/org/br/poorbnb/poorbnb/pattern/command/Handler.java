package org.br.poorbnb.poorbnb.pattern.command;

import org.br.poorbnb.poorbnb.model.Hotel;


@FunctionalInterface
public interface Handler {
    void executar(Hotel hotel);
}
