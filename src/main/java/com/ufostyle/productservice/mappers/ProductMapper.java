package com.ufostyle.productservice.mappers;

import com.ufostyle.productservice.entities.Product;
import com.ufostyle.productservice.noodle.Proceeds;

public class ProductMapper {

  public static Product product(Proceeds proceeds) {
    return Product.builder()
        .id(proceeds.getId())
        .piProduct(ProductIdMapper.piProduct(proceeds.getIdProduct()))
        .tpProduct(TypeProductMapper.tpProduct(proceeds.getProductType()))
        .idConfiguration(proceeds.getIdConfiguration())
        .build();
  }

  public static Proceeds proceeds(Product product) {
    Proceeds proceeds = new Proceeds();
    proceeds.setId(product.getId());
    proceeds.setIdProduct(ProductIdMapper.idProduct(product.getPiProduct()));
    proceeds.setProductType(TypeProductMapper.productType(product.getTpProduct()));
    proceeds.setIdConfiguration(product.getIdConfiguration());
    return proceeds;
  }
}
