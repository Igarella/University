package org.example.company.services.IMPL;

import org.example.company.DTO.ComplexId;
import org.example.company.repositories.ComplexStudentRepository;
import org.example.company.repositories.IMPL.ComplexStudentRepositoryImpl;
import org.example.company.services.ComplexStudentService;

import java.util.List;
import java.util.UUID;

public class ComplexStudentServiceImpl implements ComplexStudentService {
    @Override
    public List<ComplexId> getAllComplexStudents() {
        ComplexStudentRepository repository = new ComplexStudentRepositoryImpl();
        return repository.getAllComplexStudents();
    }

    @Override
    public ComplexId getComplexIdByStudentId(UUID studentId) {
        ComplexStudentRepository repository = new ComplexStudentRepositoryImpl();
        return repository.getComplexIdByStudentId(studentId);
    }

    @Override
    public void addComplexId(ComplexId complexId) {
        ComplexStudentRepository repository = new ComplexStudentRepositoryImpl();
        repository.addComplexId(complexId);
    }
}
