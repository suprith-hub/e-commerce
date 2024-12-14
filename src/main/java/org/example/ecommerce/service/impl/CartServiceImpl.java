package org.example.ecommerce.service.impl;

import org.example.ecommerce.exception.CartException;
import org.example.ecommerce.exception.ProductException;
import org.example.ecommerce.model.Cart;
import org.example.ecommerce.model.CartItem;
import org.example.ecommerce.model.Product;
import org.example.ecommerce.model.User;
import org.example.ecommerce.repository.CartRepository;
import org.example.ecommerce.repository.UserRepository;
import org.example.ecommerce.request.AddItemRequest;
import org.example.ecommerce.service.CartService;
import org.example.ecommerce.service.CartitemService;
import org.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private CartitemService cartitemService;
    private ProductService productService;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, CartitemService cartitemService, ProductService productService, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.cartitemService = cartitemService;
        this.productService = productService;
        this.userRepository = userRepository;
    }

    @Override
    public Cart createCart(User user) throws CartException {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCart(Long id) throws CartException {
        return null;
    }

    @Override
    public Cart updateCart(Long id, Cart cart) throws CartException {
        Optional<Cart> cartOptional = cartRepository.findById(id);
        if (cartOptional.isPresent()) {
//            Cart cart = cartOptional.get();

        }
        return null;
    }

    @Override
    public void deleteCart(Long id) throws CartException {

    }

    @Override
    public Cart addItemToCart(Long userId, AddItemRequest req) throws Exception {
        Cart cart = cartRepository.findByCustomerId(userId);
        if (cart == null) {
            throw new Exception("Cart isnt creatted");
        }
        Product product = productService.findProductById(req.getProductId());
        User user = userRepository.findById(userId).get();

        CartItem isPresent = cartitemService.cartItemExist(cart, product, req.getSize(), userId);
        if(isPresent == null) {
            CartItem newCartItem = new CartItem();
            newCartItem.setProduct(product);
            newCartItem.setQuantity(1);
            newCartItem.setUser(user);

            newCartItem.setPrice((long) (product.getPrice() * newCartItem.getQuantity()));
            newCartItem.setDiscountedPrice((long) (product.getDicsountedPrice() * newCartItem.getQuantity()));
            newCartItem.setSize(req.getSize());
            CartItem createdCartItem = cartitemService.createCartItem(newCartItem);

            cart.getCartItems().add(createdCartItem);
        }


        return null;
    }
}
