package org.example.company.services;

import org.example.company.DTO.Group;
import org.example.company.DTO.Specialization;

import java.util.List;
import java.util.UUID;

public interface SpecializationService {
    List<Specialization> getAllSpecializations();

    void addSpecialization(Specialization specialization);

    Specialization getSpecializationById(UUID specializationId);
}
