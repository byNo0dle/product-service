package com.ufostyle.productservice.entities;

import lombok.Builder;
import lombok.Data;

/**
 * Esto es la clase TypeProduct.
 */
@Builder
@Data
public class TypeProduct {

  private String typeProductId;
  private String descriptionTypeProduct;
}
