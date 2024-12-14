package org.example.ecommerce.service.impl;

import org.example.ecommerce.exception.ProductException;
import org.example.ecommerce.model.Product;
import org.example.ecommerce.model.Rating;
import org.example.ecommerce.model.User;
import org.example.ecommerce.repository.ProductRepository;
import org.example.ecommerce.repository.RatingRepository;
import org.example.ecommerce.request.RatingRequest;
import org.example.ecommerce.service.RatingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;
    private ProductRepository productRepository;

    public RatingServiceImpl(RatingRepository ratingRepository, ProductRepository productRepository) {
        this.ratingRepository = ratingRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Rating createRating(User user, RatingRequest ratingReq) throws ProductException {
        Product product = productRepository.getById(ratingReq.getProductId());
        Rating rating = new Rating();
        rating.setProduct(product);
        rating.setUser(user);
        rating.setRating(ratingReq.getRating());
//        rating.setComment(ratingReq.getComment());
        rating.setCreatedAt(LocalDateTime.now());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatingsByProduct(Long productId) throws ProductException {
        return List.of();
    }
}
