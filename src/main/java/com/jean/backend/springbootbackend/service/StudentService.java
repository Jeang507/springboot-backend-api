package com.jean.backend.springbootbackend.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jean.backend.springbootbackend.model.Student;

/**
 * Servicio encargado de manejar las operaciones relacionadas con estudiantes.
 */
@Service
public class StudentService {

    /**
     * Lista de estudiantes almacenados en memoria.
     */
    private List<Student> students = new ArrayList<>(Arrays.asList(
        new Student(123, "Jean Guillén", "123@gmail.com", 23, "Programación web"),
        new Student(456, "Carlos Guillén", "456@gmail.com", 20, "Programación 4"),
        new Student(789, "Alvarado Jean", "789@gmail.com", 21, "Programación lógica"),
        new Student(234, "Carlos Alvarado", "234@gmail.com", 22, "Arquitectura de software")
    ));

    /**
     * Devuelve la lista de todos los estudiantes.
     *
     * @return lista de estudiantes
     */
    public List<Student> getStudents(){
        return students;
    }

    /**
     * Busca un estudiante por su correo electrónico.
     *
     * @param email correo del estudiante
     * @return estudiante encontrado o null si no existe
     */
    public Student getEmail(String email){
        for (Student s : students){
            if (s.getEmail().equalsIgnoreCase(email)){
                return s;
            }
        }
        return null;
    }

    /**
     * Agrega un nuevo estudiante a la lista.
     *
     * @param student estudiante a registrar
     * @return estudiante agregado
     */
    public Student postStudents(Student student){
        students.add(student);
        return student;
    }

    /**
     * Actualiza completamente un estudiante existente.
     *
     * @param student estudiante con los datos nuevos
     * @return estudiante actualizado o null si no existe
     */
    public Student putStudents(Student student){
        for (Student s : students){
            if (s.getId() == student.getId()){
                s.setName(student.getName());
                s.setEmail(student.getEmail());
                s.setAge(student.getAge());
                s.setCourse(student.getCourse());
                return s;
            }
        }
        return null;
    }

    /**
     * Actualiza solo los campos enviados de un estudiante.
     *
     * @param student estudiante con los datos a modificar
     * @return estudiante actualizado o null si no existe
     */
    public Student patchStudents(Student student){
        for (Student s : students){
            if (s.getId() == student.getId()){

                if (student.getName() != null){
                    s.setName(student.getName());
                }

                if (student.getEmail() != null){
                    s.setEmail(student.getEmail());
                }

                if (student.getAge() != null){
                    s.setAge(student.getAge());
                }

                if (student.getCourse() != null){
                    s.setCourse(student.getCourse());
                }

                return s;
            }
        }
        return null;
    }

    /**
     * Elimina un estudiante según su id.
     *
     * @param id id del estudiante
     * @return estudiante eliminado o null si no existe
     */
    public Student deleteStudents(int id){
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getId() == id){
                Student removed = students.get(i);
                students.remove(removed);
                return removed;
            }
        }
        return null;
    }
}
