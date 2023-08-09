package com.example.ProductCustomerApiUsingJPA.Product.Service;

import com.example.ProductCustomerApiUsingJPA.Product.Entity.Product;
import com.example.ProductCustomerApiUsingJPA.Product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsList(){
        List<Product> productList=new ArrayList<Product>();
        productRepository.findAll().forEach(productList::add);
        return productList;
    }

    public Product getProductById(Integer id){
        Optional<Product> optionalProduct=productRepository.findById(id);
        if(optionalProduct.isPresent()){
            Product product=optionalProduct.get();
            return product;
        }
        return new Product();
    }

    public void postProduct(Product product){
        productRepository.save(product);
        return;
    }

    public void deleteProductById(Integer id){
        productRepository.deleteById(id);
        return;
    }


    public void updateProduct(Product product,Integer id){
        productRepository.save(product);
        return;
    }


}
