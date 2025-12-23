package com.jean.backend.springbootbackend.controller;

import org.springframework.web.bind.annotation.*;

import com.jean.backend.springbootbackend.service.StudentService;
import com.jean.backend.springbootbackend.model.Student;

import java.util.List;

/**
 * Controlador encargado de exponer los endpoints relacionados con estudiantes.
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    /**
     * Devuelve la lista de todos los estudiantes.
     *
     * @return lista de estudiantes
     */
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    /**
     * Busca un estudiante por su correo electrónico.
     *
     * @param email correo del estudiante
     * @return estudiante encontrado o null si no existe
     */
    @GetMapping("/email")
    public Student getEmail(@RequestParam String email){
        return studentService.getEmail(email);
    }

    /**
     * Agrega un nuevo estudiante.
     *
     * @param student estudiante a registrar
     * @return estudiante agregado
     */
    @PostMapping
    public Student postStudents(@RequestBody Student student){
        return studentService.postStudents(student);
    }

    /**
     * Actualiza completamente un estudiante existente.
     *
     * @param student estudiante con los datos nuevos
     * @return estudiante actualizado o null si no existe
     */
    @PutMapping
    public Student putStudents(@RequestBody Student student){
        return studentService.putStudents(student);
    }

    /**
     * Actualiza solo los campos enviados de un estudiante.
     *
     * @param student estudiante con los datos a modificar
     * @return estudiante actualizado o null si no existe
     */
    @PatchMapping
    public Student patchStudents(@RequestBody Student student){
        return studentService.patchStudents(student);
    }

    /**
     * Elimina un estudiante según su id.
     *
     * @param id id del estudiante
     * @return estudiante eliminado o null si no existe
     */
    @DeleteMapping("/{id}")
    public Student deleteStudents(@PathVariable int id){
        return studentService.deleteStudents(id);
    }
}
