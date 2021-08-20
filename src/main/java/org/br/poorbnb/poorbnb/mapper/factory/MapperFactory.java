package org.br.poorbnb.poorbnb.mapper.factory;

public interface MapperFactory {
    <T> T getMapper(Class<T> clzz);
}
