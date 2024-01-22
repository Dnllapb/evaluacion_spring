package com.autocalificablespring.autocalificable.controller;

import com.autocalificablespring.autocalificable.domain.entity.BookingMongo;
import com.autocalificablespring.autocalificable.service.BookingServiceMongo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mongo/bookings")
public class BookingControllerMongo {
@Autowired
BookingServiceMongo bookingService;
    @PostMapping
    public void save(@RequestBody BookingMongo bookingMongo) {
        bookingService.save(bookingMongo);
    }
    @GetMapping
    public List<BookingMongo> findAll()
    {
        return bookingService.findAll();
    }


    @GetMapping("/{id}")
    public Optional<BookingMongo> findById(@PathVariable String id)
    {
         return bookingService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id)
    {
     bookingService.deleteById(id);
    }

}