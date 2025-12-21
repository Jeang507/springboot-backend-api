package com.jean.backend.springbootbackend.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jean.backend.springbootbackend.service.PalindromoService;

/**
 * Controlador de si una frase es palíndromo o no.
 */
@RestController
public class PalindromoController {
    
    private final PalindromoService palindromoService;

    public PalindromoController(PalindromoService palindromoService){
        this.palindromoService = palindromoService;
    }

    /**
     * Endpoint para verificar si la frase es palíndromo o no
     * @param frase es la frase a verificar
     * @return un mensaje indicando si la frase es palíndromo o no
     */

    @GetMapping("/respuesta/{frase}")
    public String respuesta(@PathVariable String frase){

        return ("La frase " + frase + ((palindromoService.esPalindromo(frase)) ? " Es palíndromo" : " No es palíndromo"));
    }
}
