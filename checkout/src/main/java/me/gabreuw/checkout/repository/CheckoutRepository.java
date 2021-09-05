package me.gabreuw.checkout.repository;

import me.gabreuw.checkout.domain.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

    Optional<Checkout> findByCode(String code);

}