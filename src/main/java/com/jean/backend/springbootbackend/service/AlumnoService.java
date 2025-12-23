package com.jean.backend.springbootbackend.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jean.backend.springbootbackend.model.Alumno;

/**
 * Servicio encargado de manejar las operaciones relacionadas con alumnos.
 */
@Service
public class AlumnoService {

    /**
     * Lista de alumnos almacenados en memoria.
     */
    private List<Alumno> alumnos = new ArrayList<>(Arrays.asList(
        new Alumno(123, "Jean Guillén", "123@gmail.com", 23, "Programación web"),
        new Alumno(456, "Carlos Guillén", "456@gmail.com", 20, "Programación 4"),
        new Alumno(789, "Alvarado Jean", "789@gmail.com", 21, "Programación lógica"),
        new Alumno(234, "Carlos Alvarado", "234@gmail.com", 22, "Arquitectura de software")
    ));

    /**
     * Devuelve la lista de todos los alumnos.
     * @return lista de alumnos
     */
    public List<Alumno> getAlumnos(){
        return alumnos;
    }

    /**
     * Busca un alumno por su correo electrónico.
     * @param email correo del alumno
     * @return alumno encontrado o null si no existe
     */
    public Alumno getEmail(String email){
        for (Alumno a : alumnos){
            if (a.getEmail().equalsIgnoreCase(email)){
                return a;
            }
        }
        return null;
    }

    /**
     * Agrega un nuevo alumno a la lista.
     * @param alumno alumno a registrar
     * @return alumno agregado
     */
    public Alumno postAlumnos(Alumno alumno){
        alumnos.add(alumno);
        return alumno;
    }

    /**
     * Actualiza completamente un alumno existente.
     * @param alumno alumno con los datos nuevos
     * @return alumno actualizado o null si no existe
     */
    public Alumno putAlumnos(Alumno alumno){
        for(Alumno a : alumnos){
            if(a.getId() == alumno.getId()){
                a.setNombre(alumno.getNombre());
                a.setEmail(alumno.getEmail());
                a.setEdad(alumno.getEdad());
                a.setCurso(alumno.getCurso());
                return a;
            }
        }
        return null;
    }

    /**
     * Actualiza solo los campos enviados de un alumno.
     * @param alumno alumno con los datos a modificar
     * @return alumno actualizado o null si no existe
     */
    public Alumno patchAlumnos(Alumno alumno){
        for (Alumno a : alumnos){
            if (a.getId() == alumno.getId()){

                if (alumno.getNombre() != null){
                    a.setNombre(alumno.getNombre());
                }

                if (alumno.getEmail() != null){
                    a.setEmail(alumno.getEmail());
                }
                
                if (alumno.getEdad() != null){
                    a.setEdad(alumno.getEdad());
                }

                if (alumno.getCurso() != null){
                    a.setCurso(alumno.getCurso());
                }

                return a;
            }
        }
        return null;
    }

    /**
     * Elimina un alumno según su id.
     * @param id id del alumno
     * @return alumno eliminado o null si no existe
     */
    public Alumno deleteAlumnos(int id){
        for (int i = 0; i < alumnos.size(); i++){
            if(alumnos.get(i).getId() == id){
                Alumno eliminado = alumnos.get(i);
                alumnos.remove(eliminado);
                return eliminado;
            }
        }
        return null;
    }
}
