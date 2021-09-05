package me.gabreuw.checkout.repository;

import me.gabreuw.checkout.domain.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {}