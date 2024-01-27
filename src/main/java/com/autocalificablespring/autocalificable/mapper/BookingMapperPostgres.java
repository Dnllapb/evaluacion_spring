package com.autocalificablespring.autocalificable.mapper;
import com.autocalificablespring.autocalificable.domain.dto.BookingDto;
import com.autocalificablespring.autocalificable.domain.entity.BookingPostgres;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

public interface BookingMapperPostgres {

    @Mapping(source = "id", target = "id", qualifiedByName = "objectToInteger")
    BookingPostgres toEntity(BookingDto dto);

    BookingDto toDto(BookingPostgres entity);

    List<BookingPostgres> toEntityList(List<BookingDto> dtoList);

    List<BookingDto> toDtoList(List<BookingPostgres> entityList);
    @Named("objectToInteger")
    default Integer objectToInteger(Object obj){
        return Integer.valueOf(obj.toString());
    }

}
