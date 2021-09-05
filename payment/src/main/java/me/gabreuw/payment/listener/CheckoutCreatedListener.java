package me.gabreuw.payment.listener;

import com.hatanaka.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.hatanaka.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import me.gabreuw.payment.domain.Payment;
import me.gabreuw.payment.service.PaymentService;
import me.gabreuw.payment.streaming.CheckoutProcessor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckoutCreatedListener {

    private final CheckoutProcessor checkoutProcessor;

    private final PaymentService paymentService;

    @StreamListener(CheckoutProcessor.INPUT)
    public void handler(CheckoutCreatedEvent event) {
        Payment payment = paymentService
                .create(event)
                .orElseThrow();

        PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(payment.getCheckoutCode())
                .setPaymentCode(payment.getCode())
                .build();

        checkoutProcessor.output().send(
                MessageBuilder
                        .withPayload(paymentCreatedEvent)
                        .build()
        );
    }

}
