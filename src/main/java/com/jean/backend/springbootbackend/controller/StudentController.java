package com.jean.backend.springbootbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jean.backend.springbootbackend.service.StudentService;
import com.jean.backend.springbootbackend.service.StudentServiceJSON;
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
    private final StudentServiceJSON studentServiceJSON;

    public StudentController(StudentService studentService, StudentServiceJSON studentServiceJSON){
        this.studentService = studentService;
        this.studentServiceJSON = studentServiceJSON;
    }
    /**
     * Devuelve la lista de estudiantes de un archivo JSON
     * @return lista de estudaintes de un archivo JSON
     */
    @GetMapping("/json")
    public ResponseEntity<List<Student>> getStudentsFromJson(){
        return ResponseEntity.ok(studentServiceJSON.getStudentsFromJson());
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
     * @return respuesta HTTP con el estudiante encontrado o estado 404 (Not Found) si no existe
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
     * @return respuesta HTTP 201 (CREATED) y la URI del recurso creado
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
     * @return respuesta HTTP con el estudiante actualizado o estado 404 (Not Found) si no existe
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
     * @return respuesta HTTP con el estudiante actualizado parcialmente o estado 404 (Not Found) si no existe
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
     * @return respuesta HTTP con el estudiante eliminado o estado 404 (Not Found) si no existe
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
