package com.jean.backend.springbootbackend.service;
import org.springframework.stereotype.Service;


@Service
public class PalindromoService {


    public boolean esPalindromo(String texto){
        
        String textoModificado = texto.replaceAll("\\s", "").toLowerCase();
        int i = 0;
        int j = textoModificado.length() - 1;

        while (i < j){

            if (textoModificado.charAt(i) != textoModificado.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
            return true;
    }
}

