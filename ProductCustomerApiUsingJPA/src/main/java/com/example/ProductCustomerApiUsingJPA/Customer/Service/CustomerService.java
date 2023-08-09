package com.example.ProductCustomerApiUsingJPA.Customer.Service;
import com.example.ProductCustomerApiUsingJPA.Product.Entity.Product;
import com.example.ProductCustomerApiUsingJPA.Customer.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductCustomerApiUsingJPA.Customer.Entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomersList(Integer id){
        List<Customer> customerList=new ArrayList<Customer>();
//        customerList.add(new Customer(1,"rid","dahanu"));
        customerRepository.findByProductId(id).forEach(customerList::add);
        return customerList;
    }

    public Customer getCustomerById(Integer id){
        Optional<Customer> optionalCustomer=customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            Customer customer=optionalCustomer.get();
        }
        return new Customer();
    }

    public void postCustomer(Customer customer){
        customerRepository.save(customer);
        return;
    }

    public void deleteCustomerById(Integer id){
        customerRepository.deleteById(id);
        return;
    }


    public void updateCustomer(Customer customer){
        customerRepository.save(customer);
        return;
    }


}
