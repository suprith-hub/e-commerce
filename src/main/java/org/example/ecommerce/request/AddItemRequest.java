package org.example.ecommerce.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddItemRequest {
    private Long productId;
    private String size;
    private Integer quantity;
    private Integer price;
}
