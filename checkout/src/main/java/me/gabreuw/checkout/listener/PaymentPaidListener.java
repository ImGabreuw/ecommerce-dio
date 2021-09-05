package me.gabreuw.checkout.listener;

import com.hatanaka.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import me.gabreuw.checkout.domain.Checkout;
import me.gabreuw.checkout.repository.CheckoutRepository;
import me.gabreuw.checkout.streaming.PaymentPaidSink;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import static me.gabreuw.checkout.domain.enums.CheckoutStatus.APPROVED;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private CheckoutRepository checkoutRepository;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent event) {
        Checkout recoveredCheckout = checkoutRepository
                .findByCode(event.getCheckoutCode().toString())
                .orElseThrow();

        recoveredCheckout.setStatus(APPROVED);

        checkoutRepository.save(recoveredCheckout);
    }

}
