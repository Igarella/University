package org.example.company.services;

import org.example.company.DTO.Assessment;
import org.example.company.DTO.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
//@Service
public interface StudentsService {

    List<Student> getAllStudents();

    void addStudent(Student student);

    void deleteStudent(UUID uuid);

    Student  getStudentById(UUID id);

    List<Student> getDeletedStudents();


}



