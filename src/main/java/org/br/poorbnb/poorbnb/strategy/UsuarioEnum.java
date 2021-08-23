package org.br.poorbnb.poorbnb.strategy;

import org.br.poorbnb.poorbnb.model.AvaliacaoHotel;
import org.br.poorbnb.poorbnb.model.Hotel;

import org.br.poorbnb.poorbnb.service.AvaliacaoHotelService;
import org.br.poorbnb.poorbnb.service.impl.AvaliacaoHotelServiceImpl;


import java.util.List;


public enum UsuarioEnum implements AvaliacaoStrategy {

    USUARIO_COMUM {
        @Override
        public Double calcularAvaliacao(Object user, Object getAvaliacao) {
            return null;
        }
    },
    HOTEL {
        @Override
        public Double calcularAvaliacao(Object user, Object getAvaliacao) {
            Double value = 0.0d;

            if (user instanceof Hotel && getAvaliacao instanceof AvaliacaoHotelServiceImpl) {
                final Hotel hotel = (Hotel) user;
                final AvaliacaoHotelService avaliacaoService = (AvaliacaoHotelServiceImpl) getAvaliacao;

                final List<AvaliacaoHotel> avaliacaoHotels = avaliacaoService.
                        listarAvaliacoesHotel(hotel.getIdHotel());

                value = avaliacaoHotels
                        .parallelStream()
                        .reduce(0.0,
                                (acc, curr) -> acc + curr.getNotaHotel(),
                                Double::sum);

            }
            return value;
        }
    },
    DONO_HOTEL {
        @Override
        public Double calcularAvaliacao(Object user, Object getAvaliacao) {
            return null;
        }
    };

}
