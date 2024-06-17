package com.ufostyle.product_service.domain.repositories;

import com.ufostyle.product_service.domain.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}
