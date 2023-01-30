package org.example.company.services;

import org.example.company.DTO.StudentSubject;

import java.util.List;
import java.util.UUID;

public interface StudentSubjectService {

    void addSubjectStudent(StudentSubject studentSubject);

    List<StudentSubject> getAllStudentSubjects();

    List<StudentSubject> getStudentSubjectsByStudentId(UUID studentId);

    StudentSubject getStudentSubjectsByStudentAndSubjectId(UUID studentId, UUID subjectId);




}
