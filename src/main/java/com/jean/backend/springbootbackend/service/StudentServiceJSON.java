package com.jean.backend.springbootbackend.service;
import com.jean.backend.springbootbackend.model.Student;
import java.util.List;

public interface StudentServiceJSON {

    /**
     * Obtiene la lista completa de estudiantes registrados de un archivo JSON.
     * @return lista de estudiantes
     */
    
    public List<Student> getStudentsFromJson();
    
}
