package org.example.ecommerce.service;

import org.example.ecommerce.exception.CartItemException;
import org.example.ecommerce.exception.UserException;
import org.example.ecommerce.model.Cart;
import org.example.ecommerce.model.CartItem;
import org.example.ecommerce.model.Product;

public interface CartitemService {
    public CartItem createCartItem(CartItem cartItem);
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;
    public CartItem cartItemExist(Cart cart, Product product, String size, Long userId) throws CartItemException;
    public CartItem findCartItemById(Long id) throws CartItemException;
    public void deleteCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;
}
