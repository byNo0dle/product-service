package com.ufostyle.productservice.services;

import com.ufostyle.productservice.entities.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Long generateKey(String nameTable);

    Flux<Product> findAll();
    Mono<Product> findById(Long idProduct);
    Mono<Product> save(Product product);
    Mono<Product> update(Product product);
    Mono<Void> delete(Long idProduct);
    Mono<Void> fillData();
}
