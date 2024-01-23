package com.ufostyle.productservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    private String idProduct;
    private ProductId productId;
    private String descriptionProduct;
    private TypeProduct typeProduct;
    private String idConfiguration;

    @Override
    public String toString() {
        return "Product[" +
                "idProduct='" + idProduct + '\'' +
                ", productId=" + productId +
                ", descriptionProduct='" + descriptionProduct + '\'' +
                ", typeProduct=" + typeProduct +
                ", idConfiguration='" + idConfiguration + '\'' +
                "]";
    }
}
