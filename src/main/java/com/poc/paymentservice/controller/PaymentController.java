package com.poc.paymentservice.controller;

import com.poc.paymentservice.entity.Payment;
import com.poc.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments/v1")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Payment doPayment(@RequestBody Payment payment) {
        return service.doPayment(payment);
    }
}
