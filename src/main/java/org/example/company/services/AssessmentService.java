package org.example.company.services;

import org.example.company.DTO.Assessment;

import java.util.List;
import java.util.UUID;

public interface AssessmentService {

    void addAssessment(Assessment assessment);

    List<Assessment> getAssessmentsOfTopic(UUID studentSpecializationId, UUID topicId);

    List<Assessment> getAssessmentsOfSubjectStudent(UUID studentSubjectId);

    List<Assessment> getAllAssessments();

    Assessment getAssessmentById(UUID assessmentId);
}
