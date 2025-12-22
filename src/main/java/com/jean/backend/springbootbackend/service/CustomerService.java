package com.jean.backend.springbootbackend.service;
import com.jean.backend.springbootbackend.model.Customer;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Servicio que contiene la lógica para manejar clientes (Customers).
 * Aquí se implementan los métodos GET y POST.
 */
@Service
public class CustomerService {

    /**
     * Lista de clientes almacenados en memoria.
     * Se usa para simular una base de datos.
     */
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
        new Customer(123, "Jean Guillén", "Jean123", "contraseña123"),
        new Customer(456, "Juan Campos", "Juan456", "secreto456"),
        new Customer(789, "Luis Lee", "Luis789", "estado789"),
        new Customer(234, "Ariel", "Ariel234", "password234"),
        new Customer(567, "Glenn", "Glenn567", "seguro567")
    ));

    /**
     * Obtiene la lista completa de clientes.
     * @return lista de clientes
     */
    public List<Customer> getCustomers(){
        return customers;
    }

    /**
     * Busca un cliente por su nombre de usuario.
     * @param userName nombre de usuario a buscar
     * @return cliente encontrado o null si no existe
     */
    public Customer getCliente(String userName){
        for (Customer c : customers) {
            if (c.getUserName().equalsIgnoreCase(userName)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Agrega un nuevo cliente a la lista.
     * @param customer cliente recibido desde el request
     * @return cliente agregado
     */
    public Customer postCliente(Customer customer){
        customers.add(customer);
        return customer;
    }

    /**
     * Actualizar un cliente en la lista.
     * @param customer cliente recibido desde el request
     * @return cliente actualizado
     */
    public Customer putCliente(Customer customer){
        for (Customer c : customers){
            if (c.getId() == customer.getId()){
                c.setName(customer.getName());
                c.setUserName(customer.getUserName());
                c.setPassword(customer.getPassword());
                return c;
            }
        }   
        return null;
    }
}

