package org.example.company.services.IMPL;

import org.example.company.DTO.StudentGroup;
import org.example.company.repositories.StudentGroupRepository;
import org.example.company.repositories.IMPL.StudentGroupRepositoryImpl;
import org.example.company.services.StudentGroupService;

import java.util.List;
import java.util.UUID;

public class StudentGroupServiceImpl implements StudentGroupService {
    @Override
    public void addCurrentStudentToGroup(StudentGroup studentGroup) {
        StudentGroupRepository repository = new StudentGroupRepositoryImpl();
        repository.addCurrentStudentToGroup(studentGroup);

    }

    @Override
    public StudentGroup getStudentGroupByStudentId(UUID studentId) {
        StudentGroupRepository repository = new StudentGroupRepositoryImpl();
        return repository.getStudentGroupByStudentId(studentId);
    }

    @Override
    public List<StudentGroup> getAllCurrentStudentGroup() {
        StudentGroupRepository repository = new StudentGroupRepositoryImpl();
        return repository.getAllCurrentStudentGroup();
    }

}
