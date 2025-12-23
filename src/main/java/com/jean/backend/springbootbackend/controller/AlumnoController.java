package com.jean.backend.springbootbackend.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jean.backend.springbootbackend.service.AlumnoService;
import com.jean.backend.springbootbackend.model.Alumno;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }
    /**
     * Enpoint para devolver la lista de todos los alumnos.
     * @return lista de alumnos
     */
    @GetMapping
    public List<Alumno> getAlumnos(){
        return alumnoService.getAlumnos();
    }

    /**
     * Enpoint para buscar un alumno por su correo electrónico.
     * @param email correo del alumno
     * @return alumno encontrado o null si no existe
     */
    @GetMapping("/email")
    public Alumno getEmail(@RequestParam String email){
        return alumnoService.getEmail(email);
    }

    /**
     * Enpoint para agregar un nuevo alumno a la lista.
     * @param alumno alumno a registrar
     * @return alumno agregado
     */
    @PostMapping
    public Alumno postAlumnos(@RequestBody Alumno alumno){
        return alumnoService.postAlumnos(alumno);
    }

    /**
     * Endpoint para actualizar completamente un alumno existente.
     * @param alumno alumno con los datos nuevos
     * @return alumno actualizado o null si no existe
     */
    @PutMapping
    public Alumno putAlumnos(@RequestBody Alumno alumno){
        return alumnoService.putAlumnos(alumno);
    }

    /**
     * Endpoint para actualizar solo los campos enviados de un alumno.
     * @param alumno alumno con los datos a modificar
     * @return alumno actualizado o null si no existe
     */
    @PatchMapping
    public Alumno patchAlumnos(@RequestBody Alumno alumno){
        return alumnoService.patchAlumnos(alumno);
    }

    /**
     * Enpoint para eliminar un alumno según su id.
     * @param id id del alumno
     * @return alumno eliminado o null si no existe
     */
    @DeleteMapping("/{id}")
    public Alumno deleteAlumnos(@PathVariable int id){
        return alumnoService.deleteAlumnos(id);
    }
}
