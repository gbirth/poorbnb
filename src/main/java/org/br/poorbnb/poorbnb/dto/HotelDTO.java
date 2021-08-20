package org.br.poorbnb.poorbnb.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class HotelDTO {

    @NotEmpty
    private String endereco;
    @NotEmpty
    private String nomeHotel;
    @NotEmpty
    private String telefone;
    private String telefoneOpcional;
    private String desativadoSN;

}
