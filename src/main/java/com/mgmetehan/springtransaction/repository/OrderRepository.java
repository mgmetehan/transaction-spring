package com.mgmetehan.springtransaction.repository;

import com.mgmetehan.springtransaction.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
