package com.jean.backend.springbootbackend.service;

import com.jean.backend.springbootbackend.model.Customer;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class CustomerService {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
        new Customer(123, "Jean Guillén", "Jean123", "contraseña123"),
        new Customer(456, "Juan Campos", "Juan456", "secreto456"),
        new Customer(789, "Luis Lee", "Luis789", "estado789"),
        new Customer(234, "Ariel", "Ariel234", "password234"),
        new Customer(567, "Glenn", "Glenn567", "seguro567")
    ));

    public List<Customer> getCustomers(){
        return customers;
    }
}
