package com.ufostyle.productservice.services;

import com.ufostyle.productservice.entities.Product;
import com.ufostyle.productservice.entities.ProductId;
import com.ufostyle.productservice.entities.TypeProduct;
import com.ufostyle.productservice.repositories.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Esto es el ProductServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {

  Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

  @Autowired
  ProductRepository productRepository;

  @Autowired
  RestTemplate restTemplate;

  @Override
  public Flux<Product> findAll() {
    return productRepository.findAll()
        .sort((prodA, prodB) -> prodA.getIdProduct().compareTo(prodB.getIdProduct()));
  }

  @Override
  public Mono<Product> findById(String idProduct) {
    return productRepository.findById(idProduct)
        .switchIfEmpty(
            Mono.just(new Product(String.valueOf(-1), null, "", null, String.valueOf(-1))));
  }

  @Override
  public Mono<Product> save(Product product) {
    return productRepository.insert(product);
  }

  @Override
  public Mono<Product> update(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Mono<Void> delete(String idProduct) {
    return productRepository.deleteById(idProduct);
  }

  String idProduct = String.valueOf(0);

  @Override
  public Mono<Void> fillData() {
    return productRepository.findAll().count().flatMap(x -> {
      log.info("Cantidad[X]:" + x);
      List<Product> listaProducts = new ArrayList<Product>();
      listaProducts.add(new Product(String.valueOf(1), ProductId.AHORRO,
          "Ahorro", TypeProduct.PASIVOS, String.valueOf(1)));
      listaProducts.add(new Product(String.valueOf(2), ProductId.CUENTACORRIENTE,
          "Cuenta corriente", TypeProduct.PASIVOS, String.valueOf(2)));
      listaProducts.add(new Product(String.valueOf(3), ProductId.PLAZOFIJO,
          "Plazo fijo", TypeProduct.PASIVOS, String.valueOf(3)));
      listaProducts.add(new Product(String.valueOf(4), ProductId.PERSONAL,
          "Personal", TypeProduct.ACTIVOS, String.valueOf(4)));
      listaProducts.add(new Product(String.valueOf(5), ProductId.EMPRESARIAL,
          "Empresarial", TypeProduct.ACTIVOS, String.valueOf(5)));
      listaProducts.add(new Product(String.valueOf(6), ProductId.TARJETACREDITOEMPRESARIAL,
          "Tarjeta de Credito", TypeProduct.ACTIVOS, String.valueOf(6)));
      listaProducts.add(new Product(String.valueOf(7), ProductId.TARJETACREDITOPERSONAL,
          "Tarjeta de Credito personal", TypeProduct.ACTIVOS, String.valueOf(7)));
      log.info("Fill data succefull");
      idProduct = String.valueOf(x);
      return Flux.fromIterable(listaProducts).flatMap(product -> {
        log.info("[product]:" + product);
        idProduct = idProduct + 1;
        product.setIdProduct(idProduct);
        return this.save(product);
      }).then();
    }).then();
  }
}
