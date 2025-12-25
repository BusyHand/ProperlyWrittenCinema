package com.absolute.cinema.dto;

import com.absolute.cinema.entity.Payment;

public record PaymentPurchase(Payment payment, int amount) {

}
