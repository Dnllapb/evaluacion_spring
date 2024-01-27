package com.autocalificablespring.autocalificable.service;

import com.autocalificablespring.autocalificable.domain.dto.BookingDto;
import com.autocalificablespring.autocalificable.domain.entity.BookingMongo;
import com.autocalificablespring.autocalificable.domain.repository.BookingRepositoryMongo;
import com.autocalificablespring.autocalificable.mapper.BookingMapperMongo;

import java.util.List;

public class BookingServiceMongo implements BookingService<BookingDto>{
    private final BookingRepositoryMongo bookingRepositoryMongo;
    private final BookingMapperMongo mapper;

    public BookingServiceMongo(BookingRepositoryMongo bookingRepositoryMongo, BookingMapperMongo mapper) {
        this.bookingRepositoryMongo = bookingRepositoryMongo;
        this.mapper = mapper;
    }
    @Override
    public void save(BookingDto dto) {
        BookingMongo booking = mapper.toEntity(dto);
        bookingRepositoryMongo.save(booking);
    }
    @Override
    public BookingDto findById(Object id) throws Exception {
       BookingMongo bookingMongo = bookingRepositoryMongo.findById(id.toString())
               .orElseThrow(()-> new Exception("Reserva no encontrada" + id));
       return mapper.toDto(bookingMongo);
    }
    @Override
    public List<BookingDto> findAll() {
        List<BookingMongo> mongoList = bookingRepositoryMongo.findAll();
        return mapper.toDtoList(mongoList);
    }
    @Override
    public void delete(Object id) {
       bookingRepositoryMongo.deleteById(id.toString());
    }
}
