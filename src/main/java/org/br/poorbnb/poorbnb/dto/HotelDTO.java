package org.br.poorbnb.poorbnb.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.br.poorbnb.poorbnb.constant.HotelConstants;
import org.br.poorbnb.poorbnb.model.Usuario;
import org.br.poorbnb.poorbnb.vo.HotelVO;

import javax.management.AttributeNotFoundException;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Data
public class HotelDTO {

    @NotEmpty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String endereco;

    @NotEmpty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomeHotel;

    @NotEmpty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String telefone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String telefoneOpcional;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String desativadoSN;

    @NotNull
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long idUsuario;

    private Double mediaAvaliacao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String status;


    public HotelVO paraVO() throws AttributeNotFoundException {
        return new HotelVO(
                this.endereco,
                this.nomeHotel,
                this.telefone,
                this.telefoneOpcional,
                this.desativadoSN,
                new Usuario(idUsuario)
        );
    }

    public String getStatus() {
        if (this.mediaAvaliacao != null) {
            if (this.mediaAvaliacao >= HotelConstants.QUATRO_E_MEIO) {
                return "BÔNUS CONCEDIDO";
            } else if (this.mediaAvaliacao >= HotelConstants.TRES && this.mediaAvaliacao < HotelConstants.QUATRO_E_MEIO) {
                return "ESTADO PRESERVADO OU RESTRIÇÃO REMOVIDA";
            } else if (this.mediaAvaliacao >= HotelConstants.UM && this.mediaAvaliacao < HotelConstants.TRES) {
                return "RESTRIÇÃO DE PESQUISA APLICADA";
            } else if (this.mediaAvaliacao <= HotelConstants.UM) {
                return "HOTEL DESATIVADO";
            }
        }
        return "AVALIAÇÃO INCONSISTENTE OU NÃO ENCONTRADA";
    }
}
