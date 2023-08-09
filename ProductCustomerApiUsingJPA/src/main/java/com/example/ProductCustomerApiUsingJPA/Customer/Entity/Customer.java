package com.example.ProductCustomerApiUsingJPA.Customer.Entity;

import com.example.ProductCustomerApiUsingJPA.Product.Entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    private Integer id;

    @ManyToOne
    private Product product;

    private String name;
    private String address;

    public Customer(Integer id, Integer productId, String name, String address) {
        this.id = id;
        this.product = new Product(productId,"","",0);
        this.name = name;
        this.address = address;
    }
}
