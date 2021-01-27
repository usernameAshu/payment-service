package com.poc.paymentservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.poc.paymentservice.entity.Payment;

public interface PaymentService {

    Payment doPayment(Payment payment) throws JsonProcessingException;

    Payment getPaymentByOrderId(int orderId) throws JsonProcessingException;
}
