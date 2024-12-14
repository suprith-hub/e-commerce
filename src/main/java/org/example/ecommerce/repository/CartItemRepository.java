package org.example.ecommerce.repository;

import org.example.ecommerce.model.Cart;
import org.example.ecommerce.model.CartItem;
import org.example.ecommerce.model.Product;
import org.example.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    @Query("SELECT ci from CartItem ci " +
            " where ci.product=:product and " +
            "ci.cart=:cart and " +
            "ci.user.id=:userId and " +
            "ci.size=:size"
    )
    public CartItem findByCartProductAndUser(@Param("cart") Cart cart,
                                                   @Param("product") Product product,
                                                   @Param("size") String size,
                                                   @Param("user") Long userId
                                                   );
}
