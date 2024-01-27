package com.autocalificablespring.autocalificable.controller;

import com.autocalificablespring.autocalificable.domain.dto.BookingDto;
import com.autocalificablespring.autocalificable.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/booking")
public record BookingController(
        BookingService<BookingDto> bookingService
)
{
    @PostMapping("/newBooking")
    public ResponseEntity<?> createBooking(@RequestBody BookingDto bookingDto) {
        bookingService.save(bookingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/allBooking")
    public ResponseEntity<?> searchAll() {
        return new ResponseEntity<>(bookingService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable("id") Long id){
        bookingService.delete(id);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchBooking(@PathVariable ("id") Long id) throws Exception {
        bookingService.findById(id.toString());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
