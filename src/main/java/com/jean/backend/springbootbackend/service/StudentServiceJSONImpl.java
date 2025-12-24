package com.jean.backend.springbootbackend.service;

import com.jean.backend.springbootbackend.model.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceJSONImpl implements StudentServiceJSON {

    @Override
    public List<Student> getStudentsFromJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(
                this.getClass().getResourceAsStream("/student.json"),
                new TypeReference<List<Student>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Error reading student.json", e);
        }
    }
}
