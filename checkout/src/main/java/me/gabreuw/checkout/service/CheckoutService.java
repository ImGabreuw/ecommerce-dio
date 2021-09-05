package me.gabreuw.checkout.service;

import me.gabreuw.checkout.domain.Checkout;
import me.gabreuw.checkout.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<Checkout> create(CheckoutRequest request);

}