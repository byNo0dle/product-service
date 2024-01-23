package com.ufostyle.productservice.controllers;

import com.ufostyle.productservice.entities.Product;
import com.ufostyle.productservice.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @GetMapping
    public Flux<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping
    public Mono<ResponseEntity<Product>> save(@RequestBody Product product) {
        return productService.save(product).map(_product -> ResponseEntity.ok().body(_product)).onErrorResume(e -> {
            log.info("Error:" + e.getMessage());
            return Mono.just(ResponseEntity.badRequest().build());
        });
    }

    @GetMapping("/{idProduct}")
    public Mono<ResponseEntity<Product>> findById(@PathVariable(name = "idProduct") String idProduct) {
        return productService.findById(idProduct).map(product -> ResponseEntity.ok().body(product))
                .onErrorResume(e -> {
                    log.info(e.getMessage());
                    return Mono.just(ResponseEntity.badRequest().build());
                }).defaultIfEmpty(ResponseEntity.noContent().build());
    }

    @PutMapping
    public Mono<ResponseEntity<Product>> update(@RequestBody Product product) {
        // return productService.update(product);
        //// Verificar logica si aplica la busqueda del flatMap
        Mono<Product> mono = productService.findById(product.getIdProduct()).flatMap(objProduct -> {
            log.info("Update:[new]" + product + " [Old]:" + objProduct);
            return productService.update(product);
        });
        return mono.map(_product -> {
            log.info("Status:" + HttpStatus.OK);
            return ResponseEntity.ok().body(_product);
        }).onErrorResume(e -> {
            log.info("Status:" + HttpStatus.BAD_REQUEST + " message" + e.getMessage());
            return Mono.just(ResponseEntity.badRequest().build());
        }).defaultIfEmpty(ResponseEntity.noContent().build());

    };

    @DeleteMapping("/{idProduct}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable(name = "idProduct") String idProduct) {
        return productService.findById(idProduct).flatMap(producto -> {
            return productService.delete(producto.getIdConfiguration()).then(Mono.just(ResponseEntity.ok().build()));
        });
    }

    @GetMapping("/fillData")
    public Mono<Void> fillData() {
        return productService.fillData();
    }
}
