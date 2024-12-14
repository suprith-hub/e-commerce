package org.example.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class PaymentInformation {

    @Column(name = "payment_type", nullable = false)
    private String paymentType;

    @Column(name = "card_number", nullable = false, length = 16)
    private String cardNumber;

    @Column(name = "card_holder_name", nullable = false)
    private String cardHolderName;

    @Column(name = "expiry_date", nullable = false)
    private String expiryDate; // Format: MM/YY

    @Column(name = "cvv", nullable = false, length = 3)
    private String cvv; // Typically 3 or 4 digits for credit cards
}
