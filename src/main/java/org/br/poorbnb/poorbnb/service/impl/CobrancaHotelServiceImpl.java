package org.br.poorbnb.poorbnb.service.impl;

import org.br.poorbnb.poorbnb.constant.HotelConstants;
import org.br.poorbnb.poorbnb.model.CobrancaHotel;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.repository.CobrancaHotelRepository;
import org.br.poorbnb.poorbnb.service.CobrancaHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CobrancaHotelServiceImpl implements CobrancaHotelService {

    private CobrancaHotelRepository cobrancaHotelRepository;

    @Autowired
    public CobrancaHotelServiceImpl(CobrancaHotelRepository cobrancaHotelRepository) {
        this.cobrancaHotelRepository = cobrancaHotelRepository;
    }

    @Override
    public Optional<CobrancaHotel> obterUltimaCobrancaHotel(Long id) {
        final Optional<List<CobrancaHotel>> cobrancaHotels = this.cobrancaHotelRepository.obterUltimaCobrancaHotel(id);

        return cobrancaHotels.isPresent() ? Optional.of(cobrancaHotels.get().get(0)) :
                Optional.ofNullable(null);
    }

    @Override
    public CobrancaHotel conceberDesconto(Hotel hotel) {
        final Optional<CobrancaHotel> cobrancaHotel = obterUltimaCobrancaHotel(hotel.getIdHotel());
        final CobrancaHotel cobranca = criarCobranca(cobrancaHotel);

        cobranca.setMalAvaliado(HotelConstants.NAO);
        cobranca.setValorDesconto(HotelConstants.DESCONTO);
        return salvarCobranca(cobranca);
    }

    @Override
    public CobrancaHotel aplicarRestricaoPesquisa(Hotel hotel) {
        final Optional<CobrancaHotel> cobrancaHotel = obterUltimaCobrancaHotel(hotel.getIdHotel());
        final CobrancaHotel cobranca = criarCobranca(cobrancaHotel);

        cobranca.setMalAvaliado(HotelConstants.SIM);
        cobranca.setValorDesconto(null);
        return salvarCobranca(cobranca);
    }

    @Override
    public CobrancaHotel manterEstavelOuRemoverRestricao(Hotel hotel) {
        final Optional<CobrancaHotel> cobrancaHotel = obterUltimaCobrancaHotel(hotel.getIdHotel());
        final CobrancaHotel cobranca = criarCobranca(cobrancaHotel);

        cobranca.setMalAvaliado(HotelConstants.NAO);

        return salvarCobranca(cobranca);
    }

    @Override
    public Integer obterUltimoHistCobr(Optional<CobrancaHotel> cobrancaHotel) {
        final Integer histCobr = cobrancaHotel.isPresent() ? cobrancaHotel.get().getHistCobr() : HotelConstants.ZERO;
        return histCobr + HotelConstants.ONE;
    }

    @Override
    public CobrancaHotel criarCobranca(Optional<CobrancaHotel> cobrancaHotel) { ;
        final CobrancaHotel copy = new CobrancaHotel();

        cobrancaHotel.ifPresent(cobHotel -> {
         copy.setHistCobr(obterUltimoHistCobr(cobrancaHotel));
         copy.setMalAvaliado(cobHotel.getMalAvaliado());
         copy.setIdHotel(cobHotel.getIdHotel());
         copy.setValorDesconto(cobHotel.getValorDesconto());
         copy.setHotel(cobHotel.getHotel());
        });

        return cobrancaHotel.isPresent() ? copy : new CobrancaHotel(HotelConstants.ONE);
    }

    @Override
    public CobrancaHotel salvarCobranca(CobrancaHotel cobrancaHotel) {
        return this.cobrancaHotelRepository.save(cobrancaHotel);
    }

}
