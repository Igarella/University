package org.example.company.services.IMPL;

import org.example.company.DTO.Faculty;
import org.example.company.repositories.FacultyRepository;
import org.example.company.repositories.IMPL.FacultyRepositoryImpl;
import org.example.company.services.FacultyService;

import java.util.List;
import java.util.UUID;

public class FacultyServiceIMPL implements FacultyService {
    @Override
    public void addFaculty(Faculty faculty) {
        FacultyRepository repository = new FacultyRepositoryImpl();
        repository.addFaculty(faculty);

    }

    @Override
    public List<Faculty> getAllFaculties() {
        FacultyRepository repository = new FacultyRepositoryImpl();
        return repository.getAllFaculties();
    }

    @Override
    public Faculty getFacultyById(UUID facultyId) {
        FacultyRepository repository = new FacultyRepositoryImpl();
        return repository.getFacultyById(facultyId);
    }

}
