package org.br.poorbnb.poorbnb.dto;

import lombok.Data;
import org.br.poorbnb.poorbnb.model.Reserva;

import javax.validation.constraints.NotNull;

@Data
public class ReservaDTO {

    @NotNull
    private Long idHotel;
    @NotNull
    private Long idUsuario;
    @NotNull
    private Reserva reserva;
}
