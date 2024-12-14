package org.example.ecommerce.service;

import org.example.ecommerce.exception.ProductException;
import org.example.ecommerce.model.Product;
import org.example.ecommerce.request.CreateProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    public Product createProduct(CreateProductRequest req);
    public String deleteProduct(Long id) throws ProductException;
    public Product updateProduct(Long productId, Product product) throws ProductException;
    public Product findProductById(Long id) throws ProductException;
    public List<Product> findProductsByCategoryId(String category) throws ProductException;
    public Page<Product> findAllProducts(String category, List<String> color, List<String> size, String stock, Integer minPrice, Integer maxPrice,
                                         Integer minDiscount, String sortOrder, Integer pageNumber, Integer pageSize) throws ProductException;
}
