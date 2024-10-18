package com.mgmetehan.springtransaction.service;

import com.mgmetehan.springtransaction.model.Order;
import com.mgmetehan.springtransaction.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    public Order saveOrder(String productName, Long customerId) {
        Order order = Order.builder()
                .productName(productName)
                .customerId(customerId)
                .build();

        // Bilerek hata olusturarak rollback'i gostermek icin
         if (productName.equals("error")) throw new RuntimeException("Bir hata olustu!");

        return orderRepository.save(order);
    }
}
