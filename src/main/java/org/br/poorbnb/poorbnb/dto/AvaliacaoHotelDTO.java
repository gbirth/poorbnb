package org.br.poorbnb.poorbnb.dto;

import lombok.Data;
import org.br.poorbnb.poorbnb.mapper.AvaliacaoHotelMapper;
import org.br.poorbnb.poorbnb.model.AvaliacaoHotel;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.mapstruct.factory.Mappers;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AvaliacaoHotelDTO implements Serializable {

    @NotNull
    private Hotel hotel;
    @NotNull
    private Long idUsuario;
    @NotNull
    private Long idReserva;
    @NotNull
    private Double avaliacao;

    public AvaliacaoHotelDTO() {
        super();
    }

    public AvaliacaoHotelDTO(Hotel hotel, Double avaliacao) {
        this();
        this.hotel = hotel;
        this.avaliacao = avaliacao;
    }

    public AvaliacaoHotel paraEntidade() {
        final AvaliacaoHotelMapper INSTANCIA = Mappers.getMapper(AvaliacaoHotelMapper.class);
        return INSTANCIA.dtoParaEntidade(this);
    }
}
