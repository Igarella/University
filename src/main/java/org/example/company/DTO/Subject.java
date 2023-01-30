package org.example.company.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Subject {

    private UUID id;
    private final String nameSubject;
    private List<Topic> topics = new ArrayList<>();

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Topic topic) {
        this.topics.add(topic);
    }

    public Subject(String nameSubject) {
        this.id = UUID.randomUUID();
        this.nameSubject = nameSubject;
    }

    public Subject(UUID id, String nameSubject) {
        this.id = id;
        this.nameSubject = nameSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public UUID getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", nameSubject='" + nameSubject + '\'' +
                ", topics=" + topics +
                '}';
    }
}
