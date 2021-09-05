package me.gabreuw.payment.service;

import com.hatanaka.ecommerce.checkout.event.CheckoutCreatedEvent;
import me.gabreuw.payment.domain.Payment;

import java.util.Optional;

public interface PaymentService {

    Optional<Payment> create(CheckoutCreatedEvent checkoutCreatedEvent);

}
