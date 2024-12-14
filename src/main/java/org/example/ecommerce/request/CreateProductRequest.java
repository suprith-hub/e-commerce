package org.example.ecommerce.request;

import lombok.Getter;
import lombok.Setter;
import org.example.ecommerce.model.Category;
import org.example.ecommerce.model.Size;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CreateProductRequest {
    private String name;
    private String description;
    private double price;

    private int discountedPrice;
    private int discountPercentage;

    private int quantity;
    private Category topLevelCategory;
    private Category secondLevelCategory;
    private Category thirdLevelCategory;
    private String brand;
    private String imageUrl;
    private Set<Size> size = new HashSet<>();
    private String color;
}
