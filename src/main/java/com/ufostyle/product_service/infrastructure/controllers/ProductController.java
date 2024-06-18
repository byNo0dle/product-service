package com.ufostyle.product_service.infrastructure.controllers;

import com.ufostyle.product_service.domain.entities.ProductEntity;
import com.ufostyle.product_service.domain.servicies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<ProductEntity> findAllProduct() {
        return productService.findAllProduct();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity saveProduct(@RequestBody ProductEntity product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/{idProduct}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ProductEntity> findProductById(@PathVariable("idProduct") String idProduct) {
        return productService.findProductById(idProduct);
    }

    @PutMapping
    public ProductEntity updateProduct(@RequestBody ProductEntity product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{idProduct}")
    public void deleteProduct(@PathVariable("idProduct") String idProduct) {
        productService.deleteProduct(idProduct);
    }
}
