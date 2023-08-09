package com.example.ProductCustomerApiUsingJPA.Product.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ProductCustomerApiUsingJPA.Product.Entity.Product;

public interface ProductRepository extends CrudRepository<Product,Integer>{
}
