package org.example.ecommerce.service;

import org.example.ecommerce.exception.CartException;
import org.example.ecommerce.exception.ProductException;
import org.example.ecommerce.model.Cart;
import org.example.ecommerce.model.CartItem;
import org.example.ecommerce.model.User;
import org.example.ecommerce.request.AddItemRequest;

public interface CartService {
    public Cart createCart(User user) throws CartException;
    public Cart getCart(Long id) throws CartException;
    public Cart updateCart(Long id, Cart cart) throws CartException;
    public void deleteCart(Long id) throws CartException;
    public Cart addItemToCart(Long userId, AddItemRequest req) throws Exception;

}
