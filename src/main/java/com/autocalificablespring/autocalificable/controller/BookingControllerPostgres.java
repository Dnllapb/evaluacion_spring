package com.autocalificablespring.autocalificable.controller;

import com.autocalificablespring.autocalificable.domain.entity.BookingPostgres;
import com.autocalificablespring.autocalificable.service.BookingServicePostgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postgres/bookings")
public class BookingControllerPostgres {

    @Autowired
    private BookingServicePostgres bookingService;

    @PostMapping
    public ResponseEntity<Object> newBooking(@RequestBody BookingPostgres bookingPostgres)
    {
        return this.bookingService.newBooking(bookingPostgres);
    }
    @GetMapping
    public List<BookingPostgres> getBookings()
    {
        return this.bookingService.getBookings();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Object> updateBooking(@RequestBody BookingPostgres bookingPostgres)
    {
      return this.bookingService.updateBooking(bookingPostgres);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object>  deleteBooking(@PathVariable ("Id")  Integer id) {
        return this.bookingService.deleteBooking(id);
    }

}
