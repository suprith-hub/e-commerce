package org.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String name;
    private String description;
    private double price;

    @Column(name = "discounted_price")
    private double dicsountedPrice;

    @Column(name = "discount_percent")
    private int dicountPercent;

    @ElementCollection
    @Column(name = "product_size")
    private Set<Size> productSize = new HashSet<>();

    private int quantity;

    private boolean available;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
//    @JoinColumn(name = "rating_id")
    private ArrayList<Rating> rating;

    private LocalDateTime createdAt;
    private String color;
}
