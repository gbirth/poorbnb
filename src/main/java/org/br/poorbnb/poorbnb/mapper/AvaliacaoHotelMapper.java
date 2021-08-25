package org.br.poorbnb.poorbnb.mapper;

import org.br.poorbnb.poorbnb.dto.AvaliacaoHotelDTO;
import org.br.poorbnb.poorbnb.model.AvaliacaoHotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface AvaliacaoHotelMapper {

    @Mappings({
            @Mapping(source = "src.hotel.idHotel", target = "id.idHotelAvaliado"),
            @Mapping(source = "src.idUsuario", target = "id.idAvaliador"),
            @Mapping(source = "src.idReserva", target = "idReserva"),
            @Mapping(source = "src.avaliacao", target = "notaHotel")
    })
    AvaliacaoHotel dtoParaEntidade(final AvaliacaoHotelDTO src);

    @Mappings({
            @Mapping(target = "hotel.idHotel", source = "avaliacaoHotel.id.idHotelAvaliado"),
            @Mapping(target = "idUsuario", source = "avaliacaoHotel.id.idAvaliador"),
            @Mapping(target = "idReserva", source = "avaliacaoHotel.idReserva"),
            @Mapping(target = "avaliacao", source = "avaliacaoHotel.notaHotel")
    })
    AvaliacaoHotelDTO entidadeParaDTO(final AvaliacaoHotel avaliacaoHotel);
}
