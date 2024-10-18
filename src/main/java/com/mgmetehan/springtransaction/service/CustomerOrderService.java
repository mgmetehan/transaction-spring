package com.mgmetehan.springtransaction.service;

import com.mgmetehan.springtransaction.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerOrderService {
    private final CustomerService customerService;
    private final OrderService orderService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveCustomerAndOrder(String customerName, String productName) {
        Customer customer = customerService.saveCustomer(customerName);  // Musteriyi kaydet
        orderService.saveOrder(productName, customer.getId());           // Siparisi kaydet
    }
}
