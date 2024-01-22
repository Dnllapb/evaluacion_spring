package com.autocalificablespring.autocalificable.service;

import com.autocalificablespring.autocalificable.domain.entity.BookingMongo;
import com.autocalificablespring.autocalificable.repository.BookingRepositoryMongo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookingServiceMongo {
    @Autowired
    BookingRepositoryMongo bookingRepositoryMongo;

    public void save (BookingMongo bookingMongo)
    {
        bookingRepositoryMongo.save(bookingMongo);
    }
    public List<BookingMongo> findAll() {

        List<BookingMongo> bookingMongoList = bookingRepositoryMongo.findAll();
        if (bookingMongoList.isEmpty())
        {
            throw new RuntimeException("No hay reservas por consultar");
        }
        return bookingMongoList;
    }

    public Optional<BookingMongo> findById(String id)
    {
        return bookingRepositoryMongo.findById(id);
    }
    public void deleteById(String id)
    {
        bookingRepositoryMongo.deleteById(id);
    }



}
