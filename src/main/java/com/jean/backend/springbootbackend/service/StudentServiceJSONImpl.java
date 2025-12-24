package com.jean.backend.springbootbackend.service;

import com.jean.backend.springbootbackend.model.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Servicio encargado de leer estudiantes desde un archivo JSON.
 */
@Service
public class StudentServiceJSONImpl implements StudentServiceJSON {

    /**
     * Objeto utilizado para convertir JSON a objetos Java.
     */
    private final ObjectMapper objectMapper;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param objectMapper mapper JSON proporcionado por Spring
     */
    public StudentServiceJSONImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Obtiene la lista de estudiantes desde el archivo student.json.
     *
     * @return lista de estudiantes
     */
    @Override
    public List<Student> getStudentsFromJson() {
        try {
            return objectMapper.readValue(
                this.getClass().getResourceAsStream("/student.json"),
                new TypeReference<List<Student>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException("Error reading student.json", e);
        }
    }
}
