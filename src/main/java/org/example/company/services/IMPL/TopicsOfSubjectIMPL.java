package org.example.company.services.IMPL;

import org.example.company.DTO.Topic;
import org.example.company.repositories.IMPL.TopicsOfSubjectRepositoryIMPL;
import org.example.company.repositories.TopicsOfSubjectRepository;
import org.example.company.services.TopicsOfSubjectService;

import java.util.List;
import java.util.UUID;

public class TopicsOfSubjectIMPL implements TopicsOfSubjectService {
    @Override
    public List<Topic> getTopicsBySubjectSubjectId(UUID subjectId) {
        TopicsOfSubjectRepository repository = new TopicsOfSubjectRepositoryIMPL();
        return repository.getTopicsBySubjectId(subjectId);
    }

    @Override
    public List<Topic> getAllTopics() {
        TopicsOfSubjectRepository repository = new TopicsOfSubjectRepositoryIMPL();
        return repository.getAllTopics();
    }

    @Override
    public void addTopic(Topic topic) {
        TopicsOfSubjectRepository repository = new TopicsOfSubjectRepositoryIMPL();
        repository.addTopic(topic);
    }
}
