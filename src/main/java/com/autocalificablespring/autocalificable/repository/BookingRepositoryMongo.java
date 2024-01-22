package com.autocalificablespring.autocalificable.repository;

import com.autocalificablespring.autocalificable.domain.entity.BookingMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepositoryMongo extends MongoRepository <BookingMongo,String>{

}
