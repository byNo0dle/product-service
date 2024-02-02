package com.ufostyle.productservice.mappers;

import com.ufostyle.productservice.entities.ProductId;
import com.ufostyle.productservice.noodle.IdProduct;

/**
 * Esto la clase ProductIdMapper.
 */
public class ProductIdMapper {

  /**
   * Esto es la clase static ProductId.
   *
   * @param idProduct Esto es el parametro idProduct
   * @return esto es el return ProductId
   */
  public static ProductId piProduct(IdProduct idProduct) {
    return ProductId.builder()
        .productId(idProduct.getProductId())
        .descriptionProduct(idProduct.getDescriptionProduct())
        .build();
  }

  /**
   * Esto la clase static IdProduct.
   *
   * @param piProduct esto es el parametro piProduct
   * @return esto es el return de idProduct
   */
  public static IdProduct idProduct(ProductId piProduct) {
    IdProduct idProduct = new IdProduct();
    idProduct.setProductId(piProduct.getProductId());
    idProduct.setDescriptionProduct(piProduct.getDescriptionProduct());
    return idProduct;
  }
}
