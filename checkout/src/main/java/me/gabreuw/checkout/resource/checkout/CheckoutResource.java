package me.gabreuw.checkout.resource.checkout;

import lombok.RequiredArgsConstructor;
import me.gabreuw.checkout.domain.Checkout;
import me.gabreuw.checkout.service.CheckoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/v1/checkout")
@RequiredArgsConstructor
public class CheckoutResource {

    private final CheckoutService checkoutService;

    @PostMapping
    public ResponseEntity<CheckoutResponse> create(@RequestBody CheckoutRequest checkoutRequest) {
        Checkout createdCheckout = checkoutService
                .create(checkoutRequest)
                .orElseThrow();

        CheckoutResponse response = CheckoutResponse.builder()
                .code(createdCheckout.getCode())
                .build();

        return ResponseEntity
                .status(CREATED)
                .body(response);
    }

}