package org.example.company.services.IMPL;

import org.example.company.DTO.Specialization;
import org.example.company.repositories.IMPL.SpecializationRepositoryIMPL;
import org.example.company.repositories.SpecializationRepository;
import org.example.company.services.SpecializationService;

import java.util.List;
import java.util.UUID;

public class SpecializationServiceIMPL implements SpecializationService {
    @Override
    public List<Specialization> getAllSpecializations() {
        SpecializationRepository repository = new SpecializationRepositoryIMPL();
        return repository.getAllSpecializations();
    }

    @Override
    public void addSpecialization(Specialization specialization) {
        SpecializationRepository repository = new SpecializationRepositoryIMPL();
        repository.addSpecialization(specialization);
    }

    @Override
    public Specialization getSpecializationById(UUID specializationId) {
        SpecializationRepository repository = new SpecializationRepositoryIMPL();
        return repository.getSpecializationById(specializationId);
    }
}
