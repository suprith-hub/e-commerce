package org.example.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDetails {

    private String paymentMethod;
    private String status;
    private String paymentId;

    private String razorpayPaymentId;
    private String razorpayPaymentLinkId;
    private String razorpayPaymentLinkReferenceId;
    private String razorpayPaymentLinkStatus;

}
