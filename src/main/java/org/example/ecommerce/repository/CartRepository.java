package org.example.ecommerce.repository;

import org.example.ecommerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c from Cart c " +
        "where c.user.id=:user_id"
    )
    public Cart findByCustomerId(@Param("user_id") Long customerId);
}
