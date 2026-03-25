package org.example.amazonclone.service;

import org.example.amazonclone.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);

    List<Product> getAllProducts();

    void deleteProduct(Long id);
}
