package com.jean.backend.springbootbackend.service;

import org.springframework.stereotype.Service;

/**
 * Servicio encargado de validar si una frase es un palíndromo.
 */
@Service
public class PalindromoService {

    /**
     * Verifica si una frase es un palíndromo.
     *
     * @param texto frase a evaluar
     * @return {@code true} si la frase es un palíndromo,
     *         {@code false} en caso contrario
     */
    public boolean esPalindromo(String texto) {

        String textoModificado = texto.replaceAll("\\s", "").toLowerCase();
        int i = 0;
        int j = textoModificado.length() - 1;

        while (i < j) {
            if (textoModificado.charAt(i) != textoModificado.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
