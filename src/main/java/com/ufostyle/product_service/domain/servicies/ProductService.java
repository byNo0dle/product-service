package com.ufostyle.product_service.domain.servicies;

import com.ufostyle.product_service.domain.entities.ProductEntity;
import com.ufostyle.product_service.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ArrayList<ProductEntity> findAllProduct() {
        return (ArrayList<ProductEntity>) productRepository.findAll();
    }

    public ProductEntity saveProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    public Optional<ProductEntity> findProductById(String idProduct) {
        return productRepository.findById(idProduct);
    }

    public ProductEntity updateProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String idProduct) {
        productRepository.deleteById(idProduct);
    }
}
