package org.example.company.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Topic {
    private UUID id;
    private String name;
    private UUID subjectId;

    public Topic(String name, UUID subjectId) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.subjectId = subjectId;
    }

    public Topic(UUID id, String name, UUID subjectId) {
        this.id = id;
        this.name = name;
        this.subjectId = subjectId;
    }


    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjectId=" + subjectId +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(UUID subjectId) {
        this.subjectId = subjectId;
    }
}
