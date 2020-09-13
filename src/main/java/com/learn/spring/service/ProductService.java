package com.learn.spring.service;

import com.learn.spring.entity.Product;

public interface ProductService {
    void createProduct(Product product);

    void removeProduct(Integer productId);

    void updateProduct(Product product);

    Product getProductById(Integer id);
}
