package com.example.ProductCustomerApiUsingJPA.Customer.Controller;

import com.example.ProductCustomerApiUsingJPA.Customer.Entity.Customer;
import com.example.ProductCustomerApiUsingJPA.Customer.Service.CustomerService;
import com.example.ProductCustomerApiUsingJPA.Product.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;


//    get ALl Customers - Rest EndPoint
    @RequestMapping("/products/{id}/customers")
    public List<Customer> getAllCustomers(@PathVariable Integer id){
        List<Customer> listCustomer=new ArrayList<>();
        try{
            listCustomer=service.getCustomersList(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return listCustomer;

    }

    //    get Customer by id - Rest EndPoint
    @RequestMapping("/products/{productId}/customers/{id}")
    public Customer getCustomerById(@PathVariable Integer id)
    {
        return service.getCustomerById(id);
    }


    //    Post Customer - Rest EndPoint
    @PostMapping("/products/{productId}/customers")
    public String postCustomer(@RequestBody Customer InputCustomer,@PathVariable Integer productId){
        try{
            InputCustomer.setProduct(new Product(productId,"","",0));
            service.postCustomer(InputCustomer);
        }
        catch(Exception e){
            return "Failed to post the Customer";
        }
        return "Success";
    }

    //    Update Customer - Rest EndPoint
    @PatchMapping("/products/{productId}/customers/{id}")
    public String updateCustomer(@RequestBody Customer InputCustomer,@PathVariable Integer productId){
        try{
            InputCustomer.setProduct(new Product(productId,"","",0));
            service.updateCustomer(InputCustomer);
        }
        catch(Exception e){
            return "Failed to update the Customer";
        }
        return "Success";
    }

    //    Delete Customer - Rest EndPoint
    @DeleteMapping("/products/{productId}/customers/{id}")
    public String deleteProductById(@PathVariable Integer id,Integer productId){
        try{
            service.deleteCustomerById(id);
        }
        catch(Exception e){
            return "Failed to delete the customer";
        }
        return "Delete process Success";
    }

}
