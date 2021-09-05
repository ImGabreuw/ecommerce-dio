package me.gabreuw.checkout.config;

import me.gabreuw.checkout.streaming.CheckoutCreatedSource;
import me.gabreuw.checkout.streaming.PaymentPaidSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding({
        CheckoutCreatedSource.class,
        PaymentPaidSink.class
})
public class StreamingConfig {}