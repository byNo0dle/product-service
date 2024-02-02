package com.ufostyle.productservice.mappers;

import com.ufostyle.productservice.entities.TypeProduct;
import com.ufostyle.productservice.noodle.ProductType;

/**
 * Esto la clase TypeProductMapper.
 */
public class TypeProductMapper {

  /**
   * Esto la clase static TypeProduct.
   *
   * @param productType esto es el parametro prodcutType
   * @return esto es el return TypeProduct
   */
  public static TypeProduct tpProduct(ProductType productType) {
    return TypeProduct.builder()
        .typeProductId(productType.getTypeProductId())
        .descriptionTypeProduct(productType.getDescriptionTypeProduct())
        .build();
  }

  /**
   * Esto es la clase static ProductType.
   *
   * @param tpProduct esto es el parametro tpProduct
   * @return esto es el return ProductType
   */
  public static ProductType productType(TypeProduct tpProduct) {
    ProductType productType = new ProductType();
    productType.setTypeProductId(tpProduct.getTypeProductId());
    productType.setDescriptionTypeProduct(tpProduct.getDescriptionTypeProduct());
    return productType;
  }
}
