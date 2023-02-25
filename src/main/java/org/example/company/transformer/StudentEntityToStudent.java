package org.example.company.transformer;

import org.example.company.DTO.Student;
import org.example.company.entities.StudentEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentEntityToStudent {
    public Student transform(StudentEntity studentEntity) {
        Student student = new Student();
        student.setId(studentEntity.getId());
        student.setFirstName(studentEntity.getFirstName());
        student.setSecondName(studentEntity.getSecondName());
        student.setBirthday(studentEntity.getBirthDay());
        student.setArchived(studentEntity.isArchived());
        return student;
    }
}
