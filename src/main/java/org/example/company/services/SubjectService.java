package org.example.company.services;

import org.example.company.DTO.Subject;

import java.util.List;
import java.util.UUID;

public interface SubjectService {

    List<Subject> getAllSubjects();

    void addSubject(Subject subject);

    void deleteSubject(UUID uuid);

    Subject getSubjectById(UUID subjectId);
}
