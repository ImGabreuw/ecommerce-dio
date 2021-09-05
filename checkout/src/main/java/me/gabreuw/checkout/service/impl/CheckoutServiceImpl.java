package me.gabreuw.checkout.service.impl;

import lombok.RequiredArgsConstructor;
import me.gabreuw.checkout.domain.Checkout;
import me.gabreuw.checkout.repository.CheckoutRepository;
import me.gabreuw.checkout.resource.checkout.CheckoutRequest;
import me.gabreuw.checkout.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;

    @Override
    public Optional<Checkout> create(CheckoutRequest request) {
        return Optional.empty();
    }

}
