package com.autocalificablespring.autocalificable.repository;

import com.autocalificablespring.autocalificable.domain.entity.BookingPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BookingRepositoryPostgres  extends JpaRepository<BookingPostgres, Long> {

    Optional<BookingPostgres> findBookingByName(String name);
}
