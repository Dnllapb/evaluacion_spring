package com.autocalificablespring.autocalificable.service;

import com.autocalificablespring.autocalificable.domain.dto.BookingDto;
import com.autocalificablespring.autocalificable.domain.entity.BookingPostgres;
import com.autocalificablespring.autocalificable.domain.repository.BookingRepositoryPostgres;
import com.autocalificablespring.autocalificable.mapper.BookingMapperPostgres;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServicePostgres implements BookingService<BookingDto>{

    private final BookingRepositoryPostgres bookingRepositoryPostgres;
    private final BookingMapperPostgres mapper;

    public BookingServicePostgres(BookingRepositoryPostgres bookingRepositoryPostgres, BookingMapperPostgres mapper) {
        this.bookingRepositoryPostgres = bookingRepositoryPostgres;
        this.mapper = mapper;
    }

    @Override
    public void save(BookingDto dto) {
        BookingPostgres bookingPostgres = mapper.toEntity(dto);
        bookingRepositoryPostgres.save(bookingPostgres);
    }

    @Override
    public BookingDto findById(Object id) throws Exception {
        BookingPostgres booking = bookingRepositoryPostgres.findById(Long.valueOf(id.toString()))
                .orElseThrow(() -> new Exception("No found booking: " + id));
        return mapper.toDto(booking);
    }

    @Override
    public List<BookingDto> findAll() {
        List<BookingPostgres> bookingPostgres = bookingRepositoryPostgres.findAll();
        return mapper.toDtoList(bookingPostgres);
    }

    @Override
    public void delete(Object id) {
        bookingRepositoryPostgres.deleteById(Long.valueOf(id.toString()));

    }
}
