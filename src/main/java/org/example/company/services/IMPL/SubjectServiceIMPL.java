package org.example.company.services.IMPL;

import org.example.company.DTO.Subject;
import org.example.company.repositories.IMPL.SubjectRepositoryIMPL;
import org.example.company.repositories.SubjectRepository;
import org.example.company.services.SubjectService;

import java.util.List;
import java.util.UUID;

public class SubjectServiceIMPL implements SubjectService {
    @Override
    public List<Subject> getAllSubjects() {
        SubjectRepository repository = new SubjectRepositoryIMPL();
        return repository.getAllSubjects();
    }

    @Override
    public void addSubject(Subject subject) {
        SubjectRepository repository = new SubjectRepositoryIMPL();
        repository.addSubject(subject);
    }

    @Override
    public void deleteSubject(UUID uuid) {

    }

    @Override
    public Subject getSubjectById(UUID subjectId) {
        SubjectRepository repository = new SubjectRepositoryIMPL();
        return repository.getSubjectById(subjectId);
    }
}
