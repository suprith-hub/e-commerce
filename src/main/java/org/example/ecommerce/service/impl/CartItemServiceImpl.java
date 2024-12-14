package org.example.ecommerce.service.impl;

import org.example.ecommerce.exception.CartItemException;
import org.example.ecommerce.exception.UserException;
import org.example.ecommerce.model.Cart;
import org.example.ecommerce.model.CartItem;
import org.example.ecommerce.model.Product;
import org.example.ecommerce.model.User;
import org.example.ecommerce.repository.CartItemRepository;
import org.example.ecommerce.repository.CartRepository;
import org.example.ecommerce.service.CartitemService;
import org.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartitemService {

    private CartItemRepository cartItemRepository;
    private UserService userService;
    private CartRepository productService;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository, UserService userService, CartRepository productService) {
        this.cartItemRepository = cartItemRepository;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        cartItem.setQuantity(1);
        cartItem.setPrice((long) cartItem.getProduct().getPrice()*cartItem.getQuantity());
        cartItem.setDiscountedPrice((long) (cartItem.getProduct().getDicsountedPrice()*cartItem.getQuantity()));
        return cartItemRepository.save(cartItem);
    }

    // reason for userId is that the user who is the owner of this cart can only update the cart,
    // not any other person can update
    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {

        CartItem cartItemToUpdate = cartItemRepository.findById(id).orElse(null);
        User user = userService.findUserById(userId);
        if(cartItemToUpdate == null) {
            throw new CartItemException("CartItem not found");
        }
        if(!Objects.equals(user.getId(), userId)) {
            throw new CartItemException("CartItem not updated");
        }
        cartItemToUpdate.setQuantity(cartItem.getQuantity());
        cartItemToUpdate.setPrice((long) cartItem.getProduct().getPrice()*cartItem.getQuantity());
        cartItemToUpdate.setDiscountedPrice((long) (cartItem.getProduct().getDicsountedPrice()*cartItem.getQuantity()));
        return cartItemRepository.save(cartItemToUpdate);
    }

    @Override
    public CartItem cartItemExist(Cart cart, Product product, String size, Long userId) throws CartItemException {
        CartItem item = cartItemRepository.findByCartProductAndUser(cart, product, size, userId);
        if(item == null) {
            throw new CartItemException("CartItem not found");
        }
        return item;
    }

    @Override
    public CartItem findCartItemById(Long id) throws CartItemException {
        Optional<CartItem> cartItem = cartItemRepository.findById(id);
        if(cartItem.isEmpty()) {
            throw new CartItemException("CartItem not found");
        }
        return cartItem.get();
    }

    @Override
    public void deleteCartItem(Long userId, Long cartItemId) throws UserException, CartItemException {
        User user = userService.findUserById(userId);
        if(user == null || !user.getId().equals(userId)) {
            throw new UserException("User not found");
        }
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElse(null);
        if(cartItem == null) {
            throw new CartItemException("CartItem not found");
        }
        cartItemRepository.delete(cartItem);
    }
}
