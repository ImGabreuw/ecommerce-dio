package me.gabreuw.checkout.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.gabreuw.checkout.domain.enums.CheckoutStatus;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Checkout {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String code;

    @Enumerated(STRING)
    private CheckoutStatus status;

}
