package org.br.poorbnb.poorbnb.pattern.strategy;

import org.br.poorbnb.poorbnb.model.Hotel;


public enum UsuarioEnum implements AvaliacaoStrategy {
    /* Pattern para consultar a avaliacao; caso nao faça sentido removerei, mas é outro que depende
        de tabelas e serviços
     */

    USUARIO_COMUM {
        @Override
        public Double calcularAvaliacao(Object user) {
            return null;
        }
    },
    HOTEL {
        @Override
        public Double calcularAvaliacao(Object user) {
            if (user instanceof Hotel) {
                //findAvaliacao

            }
            return null;
        }
    },
    DONO_HOTEL {
        @Override
        public Double calcularAvaliacao(Object user) {
            return null;
        }
    };

}
