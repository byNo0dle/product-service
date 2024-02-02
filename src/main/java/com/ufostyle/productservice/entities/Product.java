package com.ufostyle.productservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Esto es la clase Product.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "products")
public class Product {

  @Id
  private String id;
  private ProductId piProduct;
  private TypeProduct tpProduct;
  private String idConfiguration;

  @Override
  public String toString() {
    return "Product["
        +
        "id='"
        + id
        + '\''
        +
        ", piProduct="
        + piProduct
        + '\''
        +
        ", tpProduct="
        + tpProduct
        +
        ", idConfiguration='"
        + idConfiguration
        + '\''
        +
        "]";
  }
}
