package com.demo.repository;

import org.springframework.stereotype.Repository;
import com.demo.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {

}
