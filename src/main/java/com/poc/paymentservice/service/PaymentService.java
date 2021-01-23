package com.poc.paymentservice.service;

import com.poc.paymentservice.entity.Payment;

public interface PaymentService {

    Payment doPayment(Payment payment);

    Payment getPaymentByOrderId(int orderId);
}
