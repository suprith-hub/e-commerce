package org.example.ecommerce.controller;

import org.example.ecommerce.exception.ProductException;
import org.example.ecommerce.model.Product;
import org.example.ecommerce.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController("/api")
public class ProductController {

    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProductsByCategory(@RequestParam String category, @RequestParam List<String> color,
                                                               @RequestParam List<String> size, @RequestParam Integer minPrice,
                                                               @RequestParam Integer maxPrice, @RequestParam Integer minDiscount,
                                                               @RequestParam String sort, @RequestParam String stock,
                                                               @RequestParam Integer pageNumber, @RequestParam Integer pageSize
                                               ) {
        try {
            Page<Product> products = productService.findAllProducts(
                    category, color, size, stock, minPrice, maxPrice, minDiscount, sort, pageNumber, pageSize);

            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.ACCEPTED);
        } catch (ProductException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> findProductById(@PathVariable Long productId) {
        try {
            Product product = productService.findProductById(productId);
            if (product == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(product, HttpStatus.OK);
        }catch (ProductException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
