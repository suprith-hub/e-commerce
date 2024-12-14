package org.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    private String orderNumber;
    private LocalDateTime orderDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Address shippingAddress;

    @Embedded
    private PaymentDetails paymentDetails;

    private Integer totalPrice;

    private Integer totalItems;

    private Integer discount;

    private String orderStatus;

    private LocalDateTime createdAt;

}
