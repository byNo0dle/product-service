package com.ufostyle.productservice.controllers;

import com.ufostyle.productservice.noodle.Proceeds;
import com.ufostyle.productservice.services.ProductService;
import com.ufostyle.productservice.ufo.ProductApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Esto es la clase ApiDelegateProduct esto reemplaza al controller clásico.
 */
@Component
public class ApiDelegateProduct implements ProductApiDelegate {

  @Autowired
  ProductService productService;

  @Override
  public Mono<ResponseEntity<Flux<Proceeds>>> findAllProduct(ServerWebExchange exchange) {
    return Mono.just(ResponseEntity.ok(productService.findAll()));
  }

  @Override
  public Mono<ResponseEntity<Proceeds>> saveProduct(
      Mono<Proceeds> proceeds, ServerWebExchange exchange) {
    return proceeds
        .flatMap(requestProceeds1 -> productService.save(requestProceeds1))
        .flatMap(createProceeds -> Mono.just(ResponseEntity.ok(createProceeds)));
  }

  @Override
  public Mono<ResponseEntity<Proceeds>> updateProduct(
      Mono<Proceeds> proceeds, ServerWebExchange exchange) {
    return proceeds
        .flatMap(requestProceeds2 -> productService.update(requestProceeds2))
        .flatMap(updateProduct -> Mono.just(ResponseEntity.ok(updateProduct)));
  }

  @Override
  public Mono<ResponseEntity<Proceeds>> findByIdProduct(String id, ServerWebExchange exchange) {
    return productService.findById(id)
        .flatMap(findAllProceeds -> Mono.just(ResponseEntity.ok(findAllProceeds)))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  @Override
  public Mono<ResponseEntity<Void>> deleteProduct(String id, ServerWebExchange exchange) {
    return productService.deleteById(id)
        .then(Mono.just(ResponseEntity.noContent().<Void>build()))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }
}
