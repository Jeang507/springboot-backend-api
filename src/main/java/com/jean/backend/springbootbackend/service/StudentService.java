package com.jean.backend.springbootbackend.service;
import com.jean.backend.springbootbackend.model.Student;
import java.util.List;

public interface StudentService {
    
    List<Student> getStudents();

    Student getEmail(String email);

    Student postStudents(Student student);

    Student putStudents(Student student);

    Student patchStudents(Student student);

    Student deleteStudents(int id);
}
