package com.mgmetehan.springtransaction.repository;

import com.mgmetehan.springtransaction.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
