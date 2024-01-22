package com.ufostyle.productservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private Long idProduct;
    private ProductId productId;
    private String descriptionProduct;
    private TypeProduct typeProduct;
    private Long idConfiguration;

    @Override
    public String toString() {
        return "Product[" +
                "idProduct=" + idProduct +
                ", productId=" + productId +
                ", descriptionProduct='" + descriptionProduct + '\'' +
                ", typeProduct=" + typeProduct +
                ", idConfiguration=" + idConfiguration +
                "]";
    }
}
