package org.example.ecommerce.service;

import org.example.ecommerce.exception.ProductException;
import org.example.ecommerce.model.Product;
import org.example.ecommerce.model.Rating;
import org.example.ecommerce.model.User;
import org.example.ecommerce.request.RatingRequest;

import java.util.List;

public interface RatingService {

    public Rating createRating(User user, RatingRequest ratingReq) throws ProductException;

    public List<Rating> getAllRatingsByProduct(Long productId) throws ProductException;
}
