package com.jean.backend.springbootbackend.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jean.backend.springbootbackend.service.PalindromoService;

@RestController

public class PalindromoController {
    
    private final PalindromoService palindromoService;

    public PalindromoController(PalindromoService palindromoService){
        this.palindromoService = palindromoService;
    }

    @GetMapping("/respuesta/{frase}")

    public String respuesta(@PathVariable String frase){

        return ("La frase " + frase + ((palindromoService.esPalindromo(frase)) ? " Es palindromo" : " No es palindromo"));
    }
}
