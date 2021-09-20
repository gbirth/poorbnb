package org.br.poorbnb.poorbnb.command;

import org.br.poorbnb.poorbnb.model.CobrancaHotel;
import org.br.poorbnb.poorbnb.model.Hotel;

@FunctionalInterface
public interface Handler {
    CobrancaHotel executar(Hotel hotel);
}
