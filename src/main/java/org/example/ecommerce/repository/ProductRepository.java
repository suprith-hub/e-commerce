package org.example.ecommerce.repository;

import org.example.ecommerce.model.Category;
import org.example.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("SELECT p from Product p "+
        "where (:category = NULL OR p.category.name = :category) AND" +
            "((:minPrice is NULL and :maxPrice=NULL) OR p.dicsountedPrice > :minPrice and p.dicsountedPrice<:maxPrice) AND"+
            "(:minDiscount IS NULL OR p.dicountPercent > :minDiscount) " +
            "ORDER BY " +
            "CASE WHEN :sortOrder = 'asc' THEN p.dicsountedPrice END ASC," +
            "CASE WHEN :sortOrder = 'decs' THEN p.dicsountedPrice END DESC"
    )
    public List<Product> filterProducts(@Param("category") String category, @Param("minPrice") Integer minPrice,
                                        @Param("maxPrice") Integer maxPrice,
                                        @Param("minDiscount") Integer minDiscount,
                                        @Param("sortOrder") String sortOrder
                                        );
}
