package org.example.company.repositories;

import org.example.company.DTO.Group;
import org.example.company.DTO.Specialization;
import org.example.company.services.SpecializationService;

import java.util.List;
import java.util.UUID;

public interface SpecializationRepository {

    List<Specialization> getAllSpecializations();

    void addSpecialization(Specialization specialization);

    Specialization getSpecializationById(UUID specializationId);
}
