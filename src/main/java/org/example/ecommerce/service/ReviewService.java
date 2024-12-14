package org.example.ecommerce.service;

import org.example.ecommerce.exception.ProductException;
import org.example.ecommerce.model.Product;
import org.example.ecommerce.model.Review;
import org.example.ecommerce.model.User;
import org.example.ecommerce.request.ReviewRequest;

import java.util.List;

public interface ReviewService {

    public Review createReview(User user, ReviewRequest review) throws ProductException;

    public List<Review> findAllReviewsByProduct(Long productId) throws ProductException;
}
