package com.example.ProductCustomerApiUsingJPA.Product.Controller;

import com.example.ProductCustomerApiUsingJPA.Product.Entity.Product;
import com.example.ProductCustomerApiUsingJPA.Product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    private ProductService service;


//    get ALl products - Rest EndPoint
    @RequestMapping("/products")
    public List<Product> getAllProducts(){
        return service.getProductsList();
    }

    //    get product by id - Rest EndPoint
    @RequestMapping("/products/{id}")
    public Product getProductById(@PathVariable Integer id){
        return service.getProductById(id);
    }


    //    Post product - Rest EndPoint
    @PostMapping("/products")
    public String postProduct(@RequestBody Product Inputproduct){
        try{
            service.postProduct(Inputproduct);
        }
        catch(Exception e){
            return "Failed to post the product";
        }
        return "Success";
    }


    //    Update Product - Rest EndPoint
    @PatchMapping("/products/{id}")
    public String updateProduct(@RequestBody Product Inputproduct,@PathVariable Integer id){
        try{
            service.updateProduct(Inputproduct,id);
        }
        catch(Exception e){
            return "Failed to update the product";
        }
        return "Success";
    }

    //    Delete product - Rest EndPoint
    @DeleteMapping("/products/{id}")
    public String deleteProductById(@PathVariable Integer id){
        try{
            service.deleteProductById(id);
        }
        catch(Exception e){
            return "Failed to delete the product";
        }
        return "Delete process Success";
    }

}
