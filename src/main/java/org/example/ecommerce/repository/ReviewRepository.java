package org.example.ecommerce.repository;

import org.example.ecommerce.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select r from Review r where r.product.id=:product_id")
    public List<Review> findAllReviewsByProductId(@Param("product_id") Long productId);
}
