package org.br.poorbnb.poorbnb.dto;

import lombok.Data;
import org.br.poorbnb.poorbnb.mapper.AvaliacaoHotelMapper;
import org.br.poorbnb.poorbnb.model.AvaliacaoHotel;
import org.mapstruct.factory.Mappers;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AvaliacaoHotelDTO implements Serializable {

    @NotNull
    private Long idHotel;
    @NotNull
    private Long idUsuario;
    @NotNull
    private Long idReserva;
    @NotNull
    private Double nota;

    public AvaliacaoHotel paraEntidade() {
        final AvaliacaoHotelMapper INSTANCIA = Mappers.getMapper(AvaliacaoHotelMapper.class);
        return INSTANCIA.dtoParaEntidade(this);
    }
}
