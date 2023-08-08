package com.example.ProductApiUsingJPA.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ProductApiUsingJPA.Entity.Product;

public interface ProductRepository extends CrudRepository<Product,Integer>{
}
