package org.example.company.repositories;

import org.example.company.DTO.ComplexId;

import java.util.List;
import java.util.UUID;

public interface ComplexStudentRepository {
    List<ComplexId> getAllComplexStudents();

    ComplexId getComplexIdByStudentId(UUID studentId);

    void addComplexId(ComplexId complexId);
}
