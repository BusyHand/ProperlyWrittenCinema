package com.absolute.cinema.service;

import com.absolute.cinema.dto.PaymentProcessDTO;
import com.absolute.cinema.dto.PaymentResponseDTO;
import com.absolute.cinema.dto.PaymentStatusDTO;
import com.absolute.cinema.dto.payment.PaymentProccesDto;
import com.absolute.cinema.entity.User;

public interface PaymentService {
    // Process a payment transaction from the given payment process DTO
    PaymentResponseDTO processPayment(PaymentProcessDTO paymentProcessDTO);

    // Retrieve the payment status for a specific payment ID and user
    PaymentStatusDTO getPaymentStatus(String paymentId, User user);

    // Process a detailed payment with comprehensive billing and transaction information
    PaymentResponseDTO processPaymentWithDetails(PaymentProccesDto request);
}
