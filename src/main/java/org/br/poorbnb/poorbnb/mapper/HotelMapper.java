package org.br.poorbnb.poorbnb.mapper;

import org.br.poorbnb.poorbnb.dto.HotelDTO;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.mapstruct.Mapper;

@Mapper
public interface HotelMapper {
    Hotel dtoToEntity(final HotelDTO hotel);
    HotelDTO entityToDTO(final Hotel hotel);
}
