package org.example.company.services.IMPL;

import org.example.company.DTO.StudentSubject;
import org.example.company.repositories.IMPL.StudentSubjectRepositoryIMPL;
import org.example.company.repositories.StudentSubjectRepository;
import org.example.company.services.StudentSubjectService;

import java.util.List;
import java.util.UUID;

public class StudentSubjectServiceIMPL implements StudentSubjectService {

    @Override
    public void addSubjectStudent(StudentSubject studentSubject) {
        StudentSubjectRepository repository = new StudentSubjectRepositoryIMPL();
        repository.addSubjectStudent(studentSubject);
    }

    @Override
    public List<StudentSubject> getAllStudentSubjects() {
        StudentSubjectRepository subjectRepository = new StudentSubjectRepositoryIMPL();
        subjectRepository.getAllStudentSubjects();
        return subjectRepository.getAllStudentSubjects();
    }

    @Override
    public List<StudentSubject> getStudentSubjectsByStudentId(UUID studentId) {
        StudentSubjectRepository subjectRepository = new StudentSubjectRepositoryIMPL();
        return subjectRepository.getStudentSubjectsByStudentId(studentId);
    }

    @Override
    public StudentSubject getStudentSubjectsByStudentAndSubjectId(UUID studentId, UUID subjectId) {
        StudentSubjectRepository repository = new StudentSubjectRepositoryIMPL();
        return repository.getStudentSubjectByStudentSubjectId(studentId, subjectId);
    }

}
