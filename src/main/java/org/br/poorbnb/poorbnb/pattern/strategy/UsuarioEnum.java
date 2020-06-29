package org.br.poorbnb.poorbnb.pattern.strategy;

import org.br.poorbnb.poorbnb.model.AvaliacaoHotel;
import org.br.poorbnb.poorbnb.model.Hotel;

import org.br.poorbnb.poorbnb.service.impl.AvaliacaoHotelServiceImpl;


import java.util.List;


public enum UsuarioEnum implements AvaliacaoStrategy {
    // Pattern para consultar a avaliacao do usuario comum, hotel e do dono do hotel
    
    USUARIO_COMUM {
        @Override
        public Double calcularAvaliacao(Object user, Object getAvaliacao) {
            return null;
        }
    },
    HOTEL {
        @Override
        public Double calcularAvaliacao(Object user, Object getAvaliacao) {
            Double value = null;

            if (user instanceof Hotel && getAvaliacao instanceof AvaliacaoHotelServiceImpl) {
                Hotel hotel = (Hotel) user;
                AvaliacaoHotelServiceImpl obterAvaliacao = (AvaliacaoHotelServiceImpl) getAvaliacao;
                final List<AvaliacaoHotel> avaliacaoHotels = obterAvaliacao.
                        listarAvaliacoesHotel(hotel.getIdHotel());
                value = avaliacaoHotels
                        .parallelStream()
                        .reduce(0.0, (acc, curr) -> acc + curr.getNotaHotel(), Double::sum);

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
