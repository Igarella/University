package org.example.company.repositories;

import org.example.company.DTO.Student;

import java.util.List;
import java.util.UUID;

public interface StudentsRepository {

    List<Student> getAllStudents();

    void addStudent(Student student);

    void deleteStudent(UUID uuid);

    Student getStudentById(UUID id);

    List<Student> getDeletedStudents();

}
