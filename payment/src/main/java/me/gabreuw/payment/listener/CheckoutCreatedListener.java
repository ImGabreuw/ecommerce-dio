package me.gabreuw.payment.listener;

import com.hatanaka.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.hatanaka.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import me.gabreuw.payment.streaming.CheckoutProcessor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CheckoutCreatedListener {

    private final CheckoutProcessor checkoutProcessor;

    @StreamListener(CheckoutProcessor.INPUT)
    public void handler(CheckoutCreatedEvent event) {
        // TODO Processar pagamento em um Gateway (PagSeguro, MercadoPago, etc)
        // TODO Salvar os dados de pagamento
        // TODO Enviar o evento com o pagamento processado

        PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(event.getCheckoutCode())
                .setCheckoutStatus(event.getStatus())
                .setPaymentCode(UUID.randomUUID().toString())
                .build();

        checkoutProcessor.output().send(
                MessageBuilder
                        .withPayload(paymentCreatedEvent)
                        .build()
        );
    }

}
