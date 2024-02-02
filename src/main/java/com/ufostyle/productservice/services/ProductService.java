package com.ufostyle.productservice.services;

import com.ufostyle.productservice.mappers.ProductMapper;
import com.ufostyle.productservice.noodle.Proceeds;
import com.ufostyle.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Esto es la clase ProductService.
 */
@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  RestTemplate restTemplate;

  public Flux<Proceeds> findAll() {
    return productRepository.findAll()
        .flatMap(product1 -> Mono.just(ProductMapper.proceeds(product1)));
  }

  public Mono<Proceeds> save(Proceeds proceeds) {
    return productRepository.save(ProductMapper.product(proceeds))
        .flatMap(product2 -> Mono.just(ProductMapper.proceeds(product2)));
  }

  public Mono<Proceeds> update(Proceeds proceeds) {
    return productRepository.save(ProductMapper.product(proceeds))
        .flatMap(product3 -> Mono.just(ProductMapper.proceeds(product3)));
  }

  public Mono<Proceeds> findById(String id) {
    return productRepository.findById(id)
        .flatMap(product4 -> Mono.just(ProductMapper.proceeds(product4)));
  }

  public Mono<Void> deleteById(String id) {
    return productRepository.deleteById(id);
  }
}
