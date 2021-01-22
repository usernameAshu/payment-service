package com.poc.paymentservice.service;

import com.poc.paymentservice.entity.Payment;
import com.poc.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Override
    public Payment doPayment(Payment payment) {
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaymentStatus(getPaymentStatus());
        return repository.save(payment);
    }

    private String getPaymentStatus() {
        //generally a 3rd party API call (Razorpay, Paypal)
        return new Random().nextBoolean()?"Success":"Failure";
    }
}
