package org.example.company.repositories;

import org.example.company.DTO.Subject;

import java.util.List;
import java.util.UUID;

public interface SubjectRepository {
    void addSubject(Subject subject);

    List<Subject> getAllSubjects();

    String getNameById(UUID subjectId);

    Subject getSubjectById(UUID subjectId);
}
