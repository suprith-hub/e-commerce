package org.example.ecommerce.service.impl;

import org.example.ecommerce.exception.ProductException;
import org.example.ecommerce.model.Product;
import org.example.ecommerce.model.Review;
import org.example.ecommerce.model.User;
import org.example.ecommerce.repository.ProductRepository;
import org.example.ecommerce.repository.ReviewRepository;
import org.example.ecommerce.request.ReviewRequest;
import org.example.ecommerce.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private ProductRepository productRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Review createReview(User user, ReviewRequest reviewReq) throws ProductException {
        Optional<Product> product = productRepository.findById(reviewReq.getProductId());

        if (product.isEmpty()) {
            throw new ProductException("Product not found");
        }

        Review review = new Review();
        review.setUser(user);
        review.setProduct(product.get());
        review.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findAllReviewsByProduct(Long productId) throws ProductException {
        Optional<Product> product = productRepository.findById(productId);

        if (product.isEmpty()) {
            throw new ProductException("Product not found");
        }

        return reviewRepository.findAllReviewsByProductId(productId);
    }
}
