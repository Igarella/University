package org.example.company.DTO;

import java.util.UUID;

public class Assessment {
    private UUID id;
    private UUID studentSubjectId;
    private int mark;
    private UUID topicId;

    public UUID getTopicId() {
        return topicId;
    }

    public void setTopicId(UUID topicId) {
        this.topicId = topicId;
    }

    public Assessment(UUID studentSubjectId, int mark, UUID topicId) {
        this.id = UUID.randomUUID();
        this.studentSubjectId = studentSubjectId;
        this.mark = mark;
        this.topicId = topicId;
    }

    public Assessment(UUID id, UUID studentSubjectId, int mark, UUID topicId) {
        this.id = id;
        this.studentSubjectId = studentSubjectId;
        this.mark = mark;
        this.topicId = topicId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getStudentSubjectId() {
        return studentSubjectId;
    }

    public void setStudentSubjectId(UUID studentSubjectId) {
        this.studentSubjectId = studentSubjectId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "" + mark;
    }
}
