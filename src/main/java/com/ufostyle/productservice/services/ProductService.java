package com.ufostyle.productservice.services;

import com.ufostyle.productservice.entities.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Esto es la interfaz ProductService.
 */
public interface ProductService {

  Flux<Product> findAll();

  Mono<Product> findById(String idProduct);

  Mono<Product> save(Product product);

  Mono<Product> update(Product product);

  Mono<Void> delete(String idProduct);

  Mono<Void> fillData();
}
