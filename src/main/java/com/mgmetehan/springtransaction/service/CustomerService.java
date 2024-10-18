package com.mgmetehan.springtransaction.service;

import com.mgmetehan.springtransaction.model.Customer;
import com.mgmetehan.springtransaction.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer saveCustomer(String customerName) {
        Customer customer = Customer.builder()
                .name(customerName)
                .build();

        // Bilerek hata olusturarak rollback'i gostermek icin
       if (customerName.equals("error")) throw new RuntimeException("Bir hata olustu!");

        return customerRepository.save(customer);
    }
}
