package me.gabreuw.checkout.resource.checkout;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/checkout")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CheckoutResource {

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CheckoutRequest checkoutRequest) {
        // TODO

        return ResponseEntity
                .noContent()
                .build();
    }

}