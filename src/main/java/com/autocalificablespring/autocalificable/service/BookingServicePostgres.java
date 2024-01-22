package com.autocalificablespring.autocalificable.service;

import com.autocalificablespring.autocalificable.domain.entity.BookingPostgres;
import com.autocalificablespring.autocalificable.repository.BookingRepositoryPostgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServicePostgres {

    @Autowired
    BookingRepositoryPostgres bookingRepositoryPostgres;
    HashMap<String,Object> hashMap = new HashMap<>();
    public ResponseEntity<Object> newBooking(BookingPostgres bookingPostgres)
    {
        Optional<BookingPostgres> result = bookingRepositoryPostgres.findBookingByName(bookingPostgres.getName());

        if(result.isPresent())
        {
           hashMap.put("Error",true);
           hashMap.put("Message","Book already exists");
           return new ResponseEntity<>(
                   hashMap,
                   HttpStatus.CONFLICT
           );
        }
        bookingRepositoryPostgres.save(bookingPostgres);
        hashMap.put("Info", bookingPostgres);
        hashMap.put("Message","Book save");
        return new ResponseEntity<>(hashMap,HttpStatus.CREATED);
    }
    public List<BookingPostgres> getBookings()
    {
        return this.bookingRepositoryPostgres.findAll();
    }

    public ResponseEntity<Object> updateBooking(BookingPostgres bookingPostgres) {
        Optional<BookingPostgres> result = bookingRepositoryPostgres.findById(Long.valueOf(bookingPostgres.getId()));


        if (result.isPresent() && bookingPostgres.getId() == null) {
            hashMap.put("Error", true);
            hashMap.put("Message", "Booking already exists");
            return new ResponseEntity<>
                    (       hashMap,
                            HttpStatus.CONFLICT
                    );
        }
        hashMap.put("Message", "User save");
        if (bookingPostgres.getId() != null)
        {
            hashMap.put("message","user update");
        }
        bookingRepositoryPostgres.save(bookingPostgres);
        hashMap.put("Info", bookingPostgres);

        return new ResponseEntity<>(
                hashMap,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> deleteBooking(Integer id) {
        boolean existsId = this.bookingRepositoryPostgres.existsById(Long.valueOf(id));
        if(!existsId)
        {
            hashMap.put("Error", true);
            hashMap.put("Message", "user does not exist with that id");
            return new ResponseEntity<>
                    (       hashMap,
                            HttpStatus.CONFLICT
                    );
        }
        bookingRepositoryPostgres.deleteById(Long.valueOf(id));
        hashMap.put("Message", "user delete");
        return new ResponseEntity<>
                (       hashMap,
                        HttpStatus.ACCEPTED
                );
    }


    }

