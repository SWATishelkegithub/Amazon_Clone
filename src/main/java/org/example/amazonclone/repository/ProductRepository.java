package org.example.amazonclone.repository;

import org.example.amazonclone.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
