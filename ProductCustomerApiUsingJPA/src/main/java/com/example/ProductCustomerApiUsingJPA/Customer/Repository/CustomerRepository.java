package com.example.ProductCustomerApiUsingJPA.Customer.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.ProductCustomerApiUsingJPA.Customer.Entity.Customer;
import java.util.List;
public interface CustomerRepository extends CrudRepository<Customer,Integer>{
//    public List<Products>
    public List<Customer> findByProductId(Integer productId);
}
