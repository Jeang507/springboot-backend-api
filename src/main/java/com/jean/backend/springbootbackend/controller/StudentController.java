package com.jean.backend.springbootbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jean.backend.springbootbackend.service.StudentService;

import com.jean.backend.springbootbackend.model.Student;

import java.net.URI;
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
     * @return lista de estudiantes
     */
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(studentService.getStudents());
    }

    /**
     * Busca un estudiante por su correo electrónico.
     * @param email correo del estudiante
     * @return estudiante encontrado o null si no existe
     */
    @GetMapping("/email")
    public ResponseEntity<Student> getEmail(@RequestParam String email){

        Student student = studentService.getEmail(email);

        if (student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    /**
     * Agrega un nuevo estudiante.
     * @param student estudiante a registrar
     * @return estudiante agregado
     */
    @PostMapping
    public ResponseEntity<Student> postStudents(@RequestBody Student student){

        Student created = studentService.postStudents(student);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}").buildAndExpand(created.getId())
        .toUri();
        return ResponseEntity.created(location).body(created);
    }

    /**
     * Actualiza completamente un estudiante existente.
     * @param student estudiante con los datos nuevos
     * @return estudiante actualizado o null si no existe
     */
    @PutMapping
    public ResponseEntity<Student> putStudents(@RequestBody Student student){

        Student fullUpdate = studentService.putStudents(student);

        if (fullUpdate == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fullUpdate);
    }

    /**
     * Actualiza solo los campos enviados de un estudiante.
     * @param student estudiante con los datos a modificar
     * @return estudiante actualizado o null si no existe
     */
    @PatchMapping
    public ResponseEntity<Student> patchStudents(@RequestBody Student student){

        Student partialUpdate = studentService.patchStudents(student);

        if (partialUpdate == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(partialUpdate);
    }

    /**
     * Elimina un estudiante según su id.
     * @param id id del estudiante
     * @return estudiante eliminado o null si no existe
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudents(@PathVariable int id){
        Student removed = studentService.deleteStudents(id);
        if (removed == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(removed);
    }
}
