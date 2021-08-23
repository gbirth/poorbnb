package org.br.poorbnb.poorbnb.command;

import org.br.poorbnb.poorbnb.model.Hotel;


@FunctionalInterface
public interface Handler {
    void executar(Hotel hotel);
}
