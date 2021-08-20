package org.br.poorbnb.poorbnb.mapper.factory.impl;

import org.br.poorbnb.poorbnb.mapper.factory.MapperFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class MapperFactoryImpl implements MapperFactory {

    @Override
    public <T> T getMapper(Class<T> clzz) {
        return Mappers.getMapper(clzz);
    }
}
