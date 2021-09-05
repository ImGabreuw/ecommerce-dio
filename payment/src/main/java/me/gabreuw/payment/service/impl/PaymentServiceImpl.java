package me.gabreuw.payment.service.impl;

import com.hatanaka.ecommerce.checkout.event.CheckoutCreatedEvent;
import lombok.RequiredArgsConstructor;
import me.gabreuw.payment.domain.Payment;
import me.gabreuw.payment.repository.PaymentRepository;
import me.gabreuw.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Optional<Payment> create(CheckoutCreatedEvent checkoutCreatedEvent) {
        Payment paymentEntity = Payment.builder()
                .checkoutCode(checkoutCreatedEvent.getCheckoutCode().toString())
                .code(UUID.randomUUID().toString())
                .build();

        paymentRepository.save(paymentEntity);

        return Optional.of(paymentEntity);
    }

}
