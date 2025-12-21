package com.jean.backend.springbootbackend.controller;
import com.jean.backend.springbootbackend.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jean.backend.springbootbackend.service.CustomerService;
import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customersService;

    public CustomerController(CustomerService customerService){
        this.customersService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customersService.getCustomers();
    }   
}
