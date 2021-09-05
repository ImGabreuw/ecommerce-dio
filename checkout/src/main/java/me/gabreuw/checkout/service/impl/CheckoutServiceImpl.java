package me.gabreuw.checkout.service.impl;

import com.hatanaka.ecommerce.checkout.event.CheckoutCreatedEvent;
import lombok.RequiredArgsConstructor;
import me.gabreuw.checkout.domain.Checkout;
import me.gabreuw.checkout.repository.CheckoutRepository;
import me.gabreuw.checkout.resource.checkout.CheckoutRequest;
import me.gabreuw.checkout.service.CheckoutService;
import me.gabreuw.checkout.streaming.CheckoutCreatedSource;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static me.gabreuw.checkout.domain.enums.CheckoutStatus.CREATED;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final CheckoutCreatedSource checkoutCreatedSource;

    @Override
    public Optional<Checkout> create(CheckoutRequest request) {
        Checkout checkout = Checkout.builder()
                .code(UUID.randomUUID().toString())
                .status(CREATED)
                .build();

        Checkout savedCheckout = checkoutRepository.save(checkout);

        CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(savedCheckout.getCode())
                .setStatus(savedCheckout.getStatus().name())
                .build();

        checkoutCreatedSource.output().send(
                MessageBuilder
                        .withPayload(checkoutCreatedEvent)
                        .build()
        );

        return Optional.of(savedCheckout);
    }

}
