package org.example.company.services;

import org.example.company.DTO.Faculty;

import java.util.List;
import java.util.UUID;

public interface FacultyService {
    void addFaculty(Faculty faculty);

    List<Faculty> getAllFaculties();

    Faculty getFacultyById(UUID facultyId);
}
