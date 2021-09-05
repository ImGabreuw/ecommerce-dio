package me.gabreuw.checkout.service.impl;

import lombok.RequiredArgsConstructor;
import me.gabreuw.checkout.domain.Checkout;
import me.gabreuw.checkout.domain.enums.CheckoutStatus;
import me.gabreuw.checkout.repository.CheckoutRepository;
import me.gabreuw.checkout.resource.checkout.CheckoutRequest;
import me.gabreuw.checkout.service.CheckoutService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static me.gabreuw.checkout.domain.enums.CheckoutStatus.CREATED;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;

    @Override
    public Optional<Checkout> create(CheckoutRequest request) {
        Checkout checkout = Checkout.builder()
                .code(UUID.randomUUID().toString())
                .status(CREATED)
                .build();

        return Optional.of(
                checkoutRepository.save(checkout)
        );
    }

}
