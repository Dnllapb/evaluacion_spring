package com.autocalificablespring.autocalificable.mapper.base;

import org.mapstruct.factory.Mappers;

public interface IBaseMapper {
    IBaseMapper INSTANCE = Mappers.getMapper(IBaseMapper.class);
}
