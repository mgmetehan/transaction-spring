package com.mgmetehan.springtransaction.controller;

import com.mgmetehan.springtransaction.service.CustomerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers-orders")
@RequiredArgsConstructor
public class CustomerOrderController {
    private final CustomerOrderService customerOrderService;

    @PostMapping("/createCustomerOrder")
    public String createCustomerOrder(@RequestParam String customerName,
                                      @RequestParam String productName) {
        try {
            customerOrderService.saveCustomerAndOrder(customerName, productName);
            return "Musteri ve Siparis basariyla kaydedildi.";
        } catch (Exception e) {
            return "Islem basarisiz oldu: " + e.getMessage();
        }
    }
}
