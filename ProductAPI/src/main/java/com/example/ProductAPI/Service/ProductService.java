package com.example.ProductAPI.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.ProductAPI.Entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private List<Product> productsList=new ArrayList<Product>();

    public List<Product> getProductsList(){
        return productsList;
    }

    public Product getProductById(Integer id){
        return productsList.stream().filter(product-> product.getId().equals(id)).findFirst().get();
    }

    public void postProduct(Product product){
        Product temp=new Product(product.getId(),product.getName(),product.getDesc(),product.getAmount());
        productsList.add(temp);
        return;
    }

    public void deleteProductById(Integer id){
        int iterator=0;
        while(iterator!=productsList.size()){
            if(productsList.get(iterator).getId().equals(id)){
                productsList.remove(iterator);
                break;
            }
            iterator=iterator+1;
        }
        return;
    }


    public void patchProduct(Product product,Integer id){
        int iterator=0;
        while(iterator!=productsList.size()){
            if(productsList.get(iterator).getId().equals(id)){
                Product temp=productsList.get(iterator);
                temp.setName(product.getName());
                temp.setAmount(product.getAmount());
                temp.setDesc(product.getDesc());
                break;
            }
            iterator+=1;
        }
        return;
    }


}
