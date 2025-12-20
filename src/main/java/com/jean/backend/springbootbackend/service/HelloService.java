package com.jean.backend.springbootbackend.service;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String saludar(String nombre){
        return ("Hola " + nombre + " desde el módulo service");
    }
}
