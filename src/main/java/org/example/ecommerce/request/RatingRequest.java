package org.example.ecommerce.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingRequest {

    private Long productId;
    private int rating;
    private String comment;
}
