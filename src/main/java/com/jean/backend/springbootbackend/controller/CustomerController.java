package com.jean.backend.springbootbackend.controller;
import com.jean.backend.springbootbackend.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jean.backend.springbootbackend.service.CustomerService;
import java.util.List;

/**
 * Controlador REST para manejar solicitudes de clientes.
 */
@RestController
public class CustomerController {

    private final CustomerService customersService;

    public CustomerController(CustomerService customerService)
    {
        this.customersService = customerService;
    }

    /**
     * Endpoint para obtener la lista completa de clientes.
     * @return Lista de clientes
     */
    @GetMapping("/customers")
    public List<Customer> getCustomers()
    {
        return customersService.getCustomers();
    }

    /**
     * Endpoint para obtener un cliente según su nombre de usuario.
     * @param userName nombre de usuario del cliente
     * @return cliente encontrado o null si no existe el cliente
     */
    @GetMapping("/customers/username/{userName}")
    public Customer getCliente(@PathVariable String userName)
    {
        return customersService.getCliente(userName);
    }

    /**
     * Endpoint para registrar un nuevo usuario.
     * @param customer cliente recibido en el cuerpo de la petición
     * @return cliente registrado
     */
    @PostMapping("/customers")
    public Customer postCliente(@RequestBody Customer customer)
    {
        return customersService.postCliente(customer);
    }

    /**
     * Endpoint para actualizar un cliente existente.y
     * @param customer cliente recibido en el cuerpo de la petición
     * @return cliente actualizado
     */
    @PutMapping("/customers")
    public Customer putCliente(@RequestBody Customer customer)
    {
        return customersService.putCliente(customer);
    }
}
