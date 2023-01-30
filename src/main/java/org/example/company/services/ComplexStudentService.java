package org.example.company.services;

import org.example.company.DTO.ComplexId;

import java.util.List;
import java.util.UUID;

public interface ComplexStudentService {
    List<ComplexId> getAllComplexStudents();

    ComplexId getComplexIdByStudentId(UUID studentId);

    void addComplexId(ComplexId complexId);
}
