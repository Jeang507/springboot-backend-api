package com.jean.backend.springbootbackend.service;
import com.jean.backend.springbootbackend.model.Student;
import java.util.List;

public interface StudentService {
    
    public List<Student> getStudents();

    public Student getEmail(String email);

    public Student postStudents(Student student);

    public Student putStudents(Student student);

    public Student patchStudents(Student student);

    public Student deleteStudents(int id);
}
