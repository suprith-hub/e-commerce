package org.example.ecommerce.service.impl;

import org.example.ecommerce.exception.ProductException;
import org.example.ecommerce.model.Category;
import org.example.ecommerce.model.Product;
import org.example.ecommerce.repository.CategoryRepository;
import org.example.ecommerce.repository.ProductRepository;
import org.example.ecommerce.request.CreateProductRequest;
import org.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(CreateProductRequest req) {
        Category topLevelCategory = req.getTopLevelCategory();

        if(categoryRepository.findByName(topLevelCategory.getName()) == null) {
            Category category = new Category();
            category.setName(topLevelCategory.getName());
            category.setLevel(1);
            topLevelCategory = categoryRepository.save(category);
        }

        Category secondLevelCategory = req.getSecondLevelCategory();
        if(categoryRepository.findByParentAndName(topLevelCategory.getName(), secondLevelCategory.getName()) == null) {
            Category category = new Category();
            category.setName(secondLevelCategory.getName());
            category.setLevel(2);
            category.setParentCategory(topLevelCategory);
            secondLevelCategory = categoryRepository.save(category);
        }

        Category thirdLevelCategory = req.getThirdLevelCategory();
        if(categoryRepository.findByParentAndName(secondLevelCategory.getName(), thirdLevelCategory.getName()) == null) {
            Category category = new Category();
            category.setName(thirdLevelCategory.getName());
            category.setLevel(3);
            category.setParentCategory(topLevelCategory);
            thirdLevelCategory = categoryRepository.save(category);
        }

        Product product = new Product();
        product.setName(req.getName());
        product.setDescription(req.getDescription());
        product.setPrice(req.getPrice());
        product.setDescription(req.getDescription());
        product.setDicountPercent(req.getDiscountPercentage());
        product.setImageUrl(req.getImageUrl());
        product.setBrand(req.getBrand());
        product.setProductSize(req.getSize());
        product.setColor(req.getColor());
        product.setCategory(thirdLevelCategory);
        product.setCreatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public String deleteProduct(Long id) throws ProductException {
        Product product = findProductById(id);
        if(product == null) {
            throw new ProductException("Product not found");
        }
        productRepository.delete(product);
        return "";
    }

    @Override
    public Product updateProduct(Long productId, Product product) throws ProductException {
        return null;
    }

    @Override
    public Product findProductById(Long id) throws ProductException {
        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent()) {
            return product.get();
        }
        throw new ProductException("Product not found with id -"+ id);
    }

    @Override
    public List<Product> findProductsByCategoryId(String category) throws ProductException {
        return List.of();
    }

    @Override
    public Page<Product> findAllProducts(String category, List<String> colors, List<String> size, String stock, Integer minPrice, Integer maxPrice, Integer minDiscount, String sortOrder, Integer pageNumber, Integer pageSize) throws ProductException {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        List<Product> products = productRepository.filterProducts(category, minPrice, maxPrice, minDiscount, sortOrder);

        if(!colors.isEmpty()) {
            products = products.stream().filter((item)-> colors.stream().anyMatch((color)-> color.equalsIgnoreCase(item.getColor()))).collect(Collectors.toList());
        }

        if(stock != null) {
            if(stock.equals("in_stock")) {
                products = products.stream().filter((product) -> product.getQuantity() > 0).collect(Collectors.toList());
            }else{
                products = products.stream().filter((product) -> product.getQuantity() <= 0).collect(Collectors.toList());
            }
        }

        int startIndex = (int)pageable.getOffset();
        int endIndex = Math.min(startIndex + pageSize, products.size());

        List<Product> pageContent = products.subList(startIndex, endIndex);

        Page<Product> filteredProducts = new PageImpl<>(pageContent, pageable, products.size());

        return filteredProducts;
    }
}
