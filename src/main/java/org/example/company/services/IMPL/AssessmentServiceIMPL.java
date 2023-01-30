package org.example.company.services.IMPL;

import org.example.company.DTO.Assessment;
import org.example.company.repositories.AssessmentRepository;
import org.example.company.repositories.IMPL.AssessmentRepositoryIMPL;
import org.example.company.services.AssessmentService;

import java.util.List;
import java.util.UUID;

public class AssessmentServiceIMPL implements AssessmentService {

    @Override
    public void addAssessment(Assessment assessment) {
        AssessmentRepository repository = new AssessmentRepositoryIMPL();
        repository.addAssessment(assessment);
    }

    @Override
    public List<Assessment> getAssessmentsOfTopic(UUID studentSubjectId, UUID topicId) {
        AssessmentRepository repository = new AssessmentRepositoryIMPL();
        return repository.getAssessmentsOfTopic(studentSubjectId, topicId);
    }

    @Override
    public List<Assessment> getAssessmentsOfSubjectStudent(UUID studentSubjectId) {
        AssessmentRepository repository = new AssessmentRepositoryIMPL();
        return repository.getAssessmentsOfSubjectStudent(studentSubjectId);
    }

    @Override
    public List<Assessment> getAllAssessments() {
        AssessmentRepository repository = new AssessmentRepositoryIMPL();
        return repository.getAllAssessments();
    }

    @Override
    public Assessment getAssessmentById(UUID assessmentId) {
        AssessmentRepository repository = new AssessmentRepositoryIMPL();
        return repository.getAssessmentById(assessmentId);
    }
}
