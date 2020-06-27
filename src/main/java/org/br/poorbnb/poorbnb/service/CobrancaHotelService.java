package org.br.poorbnb.poorbnb.service;

import org.br.poorbnb.poorbnb.model.CobrancaHotel;
import org.br.poorbnb.poorbnb.model.Hotel;

import java.util.Optional;

public interface CobrancaHotelService {

    Optional<CobrancaHotel> obterUltimaCobrancaHotel(Long id);

    CobrancaHotel conceberDesconto(Hotel hotel);

    CobrancaHotel aplicarRestricaoPesquisa(Hotel hotel);

    CobrancaHotel manterEstavelOuRemoverRestricao(Hotel hotel);

    Integer obterUltimoHistCobr(Optional<CobrancaHotel> cobrancaHotel);

    CobrancaHotel criarCobranca(Optional<CobrancaHotel> cobrancaHotel);

    CobrancaHotel salvarCobranca(CobrancaHotel cobrancaHotel);
}
