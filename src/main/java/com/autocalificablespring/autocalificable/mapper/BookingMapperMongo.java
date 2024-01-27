package com.autocalificablespring.autocalificable.mapper;
import com.autocalificablespring.autocalificable.domain.dto.BookingDto;
import com.autocalificablespring.autocalificable.domain.entity.BookingMongo;
import com.autocalificablespring.autocalificable.mapper.base.IBaseMapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;


public interface BookingMapperMongo extends IBaseMapper {

    @Mapping(source = "id", target = "id", qualifiedByName = "objectToString")
    BookingMongo toEntity(BookingDto bookingDtodto);

    BookingDto toDto(BookingMongo bookingEntity);

    List<BookingMongo> toEntityList(List<BookingDto> dtoList);

    List<BookingDto> toDtoList(List<BookingMongo> entityList);
    @Named("objectToString")
    default String objectToString(Object obj) {
        return obj.toString();
    }
}
