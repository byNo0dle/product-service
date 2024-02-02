package com.ufostyle.productservice.repositories;

import com.ufostyle.productservice.entities.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Esto es la interfaz ProductRepository.
 */
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
