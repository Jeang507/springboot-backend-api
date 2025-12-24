package com.jean.backend.springbootbackend.service;
import com.jean.backend.springbootbackend.model.Student;
import java.util.List;

public interface StudentService {

    /**
     * Obtiene la lista completa de estudiantes registrados.
     * @return lista de estudiantes
     */
    List<Student> getStudents();

    /**
     * Busca un estudiante por su correo electrónico.
     * @param email correo electrónico del estudiante
     * @return estudiante encontrado o {@code null} si no existe
     */
    Student getEmail(String email);

    /**
     * Registra un nuevo estudiante.
     * @param student estudiante a registrar
     * @return estudiante registrado
     */
    Student postStudents(Student student);

    /**
     * Actualiza completamente un estudiante existente.
     * @param student estudiante con los datos actualizados
     * @return estudiante actualizado o {@code null} si no existe
     */
    Student putStudents(Student student);

    /**
     * Actualiza parcialmente un estudiante existente.
     * @param student estudiante con los campos a modificar
     * @return estudiante actualizado o {@code null} si no existe
     */
    Student patchStudents(Student student);

    /**
     * Elimina un estudiante según su identificador.
     * @param id identificador del estudiante
     * @return estudiante eliminado o {@code null} si no existe
     */
    Student deleteStudents(int id);
}
