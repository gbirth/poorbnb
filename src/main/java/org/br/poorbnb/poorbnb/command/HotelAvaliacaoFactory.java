package org.br.poorbnb.poorbnb.command;

import org.br.poorbnb.poorbnb.constant.HotelConstants;
import org.br.poorbnb.poorbnb.model.CobrancaHotel;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.service.CobrancaHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;

@Component
public class HotelAvaliacaoFactory {

    private final Map<Condicao, Handler> condicaoHandlerMap;

    @Autowired
    public HotelAvaliacaoFactory(final CobrancaHotelService cobrancaHotelService) {
        this.condicaoHandlerMap = Map.ofEntries(
                new AbstractMap.SimpleEntry<Condicao, Handler>((r) -> r >= HotelConstants.QUATRO_E_MEIO,
                        cobrancaHotelService::conceberDesconto),
                new AbstractMap.SimpleEntry<Condicao, Handler>((r) -> r >= HotelConstants.TRES && r < HotelConstants.QUATRO_E_MEIO,
                        cobrancaHotelService::manterEstavelOuRemoverRestricao),
                new AbstractMap.SimpleEntry<Condicao, Handler>((r) -> r >= HotelConstants.UM && r < HotelConstants.TRES,
                        cobrancaHotelService::aplicarRestricaoPesquisa)
        );
    }

    public CobrancaHotel aplicaPoliticaAvaliacao(final Double avaliacao, final Hotel hotel) {
        final Handler handler = this.condicaoHandlerMap.get(avaliacao);
        Objects.requireNonNull(handler);
        return handler.executar(hotel);
    }
}
