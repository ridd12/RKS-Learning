package com.example.ProductApiUsingJPA.Service;

import com.example.ProductApiUsingJPA.Entity.Product;
import com.example.ProductApiUsingJPA.Repository.ProductRepository;
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
//        productRepository.findAll().forEach(productList::add);
        return productList;
    }

    public Product getProductById(Integer id){
        Optional<Product> optionalProduct=productRepository.findById(id);
        if(optionalProduct.isPresent()){
            Product product=optionalProduct.get();
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
