package org.example.company.repositories;

import org.example.company.DTO.Faculty;

import java.util.List;
import java.util.UUID;

public interface FacultyRepository {
    void addFaculty(Faculty faculty);

    List<Faculty> getAllFaculties();

    Faculty getFacultyById(UUID facultyId);
}
