package org.example.ecommerce.repository;

import org.example.ecommerce.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {


    @Query("select r from Rating r "+
        "where r.product.id=:product_id"
    )
    public List<Rating> findByProductId(@Param("product_id") Long productId);
}
