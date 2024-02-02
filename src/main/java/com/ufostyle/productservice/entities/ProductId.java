package com.ufostyle.productservice.entities;

import lombok.Builder;
import lombok.Data;

/**
 * Esto es la clase ProductId.
 */
@Builder
@Data
public class ProductId {

  private String productId;
  private String descriptionProduct;
}
