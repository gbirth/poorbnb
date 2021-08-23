package org.br.poorbnb.poorbnb.service.impl;

import org.br.poorbnb.poorbnb.constant.HotelConstants;
import org.br.poorbnb.poorbnb.event.AppEvent;
import org.br.poorbnb.poorbnb.model.CobrancaHotel;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.repository.CobrancaHotelRepository;
import org.br.poorbnb.poorbnb.service.CobrancaHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CobrancaHotelServiceImpl implements CobrancaHotelService {

    private CobrancaHotelRepository cobrancaHotelRepository;

    @Autowired
    public CobrancaHotelServiceImpl(CobrancaHotelRepository cobrancaHotelRepository) {
        this.cobrancaHotelRepository = cobrancaHotelRepository;
    }

    @EventListener({AppEvent.class})
    public void handleHotelInserido(AppEvent appEvent) {
        final Hotel source = (Hotel) appEvent.getSource();
        final CobrancaHotel cobrancaHotel = criarCobranca();

        cobrancaHotel.setIdHotel(source.getIdHotel());
        cobrancaHotel.setValorDesconto(null);
        salvarCobranca(cobrancaHotel);
    }

    @Override
    public CobrancaHotel conceberDesconto(Hotel hotel) {
        final CobrancaHotel cobrancaHotel = obterUltimaCobrancaHotel(hotel.getIdHotel());
        final CobrancaHotel cobranca = atualizarCobranca(cobrancaHotel);

        cobranca.setIdHotel(hotel.getIdHotel());
        cobranca.setHotel(hotel);
        cobranca.setMalAvaliado(HotelConstants.NAO);
        cobranca.setValorDesconto(HotelConstants.TRINTA_E_CINCO_BIG_DECIMAL);
        return salvarCobranca(cobranca);
    }

    @Override
    public CobrancaHotel aplicarRestricaoPesquisa(Hotel hotel) {
        final CobrancaHotel cobrancaHotel = obterUltimaCobrancaHotel(hotel.getIdHotel());
        final CobrancaHotel cobranca = atualizarCobranca(cobrancaHotel);

        cobranca.setIdHotel(hotel.getIdHotel());
        cobranca.setHotel(hotel);
        cobranca.setMalAvaliado(HotelConstants.SIM);
        cobranca.setValorDesconto(null);
        return salvarCobranca(cobranca);
    }

    @Override
    public CobrancaHotel manterEstavelOuRemoverRestricao(Hotel hotel) {
        final CobrancaHotel cobrancaHotel = obterUltimaCobrancaHotel(hotel.getIdHotel());
        final CobrancaHotel cobranca = atualizarCobranca(cobrancaHotel);

        cobranca.setIdHotel(hotel.getIdHotel());
        cobranca.setHotel(hotel);

        return salvarCobranca(cobranca);
    }

    @Override
    public Integer obterUltimoHistCobr(Integer historicoCobranca) {
        final Integer histCobrancaAtualizado = Objects.nonNull(historicoCobranca) ? historicoCobranca : HotelConstants.ZERO;
        return histCobrancaAtualizado + HotelConstants.UM;
    }

    @Override
    public CobrancaHotel criarCobranca() {
        return new CobrancaHotel(HotelConstants.UM, HotelConstants.NAO);
    }

    @Override
    public CobrancaHotel obterUltimaCobrancaHotel(Long id) {
        final List<CobrancaHotel> cobrancaHotels = this.cobrancaHotelRepository.obterUltimaCobrancaHotel(id);
        return cobrancaHotels.stream().findFirst().orElse(null);
    }

    @Override
    public CobrancaHotel atualizarCobranca(CobrancaHotel cobrancaHotel) {
        final Integer histCobranca = obterUltimoHistCobr(cobrancaHotel.getHistCobr());
        return new CobrancaHotel(histCobranca, cobrancaHotel);
    }

    @Override
    public CobrancaHotel salvarCobranca(CobrancaHotel cobrancaHotel) {
        return this.cobrancaHotelRepository.save(cobrancaHotel);
    }
}
