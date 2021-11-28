package com.tranquyet.converter;

public interface IBasedConverter<E,D> {

    E toEntity(D dto);

    D toDTO(E entity);

}
