package com.poc.paymentservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.paymentservice.entity.Payment;
import com.poc.paymentservice.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private PaymentRepository repository;

    @Override
    public Payment doPayment(Payment payment) throws JsonProcessingException {
        payment.setTransactionId(UUID
                .randomUUID()
                .toString());
        payment.setPaymentStatus(getPaymentStatus());
        Payment paymenResponse = repository.save(payment);
        LOGGER.info("payment-service request:doPayment : {}", new ObjectMapper().writeValueAsString(paymenResponse));
        return paymenResponse;
    }

    @Override
    public Payment getPaymentByOrderId(int orderId) throws JsonProcessingException {
        Payment paymentResponse = repository.findByOrderId(orderId);
        LOGGER.info("payment-service request:getPaymentByOrderId : {}",
                new ObjectMapper().writeValueAsString(paymentResponse));
        return paymentResponse;
    }

    private String getPaymentStatus() {
        //generally a 3rd party API call (Razorpay, Paypal)
        return new Random().nextBoolean()
                ? "Success"
                : "Failure";
    }
}
