package org.example.company.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentSubject {
    private UUID id;
    private UUID studentId;
    private UUID subjectId;
    private List<Assessment> marks = new ArrayList<>();

    public StudentSubject(UUID id, UUID studentId, UUID subject) {
        this.id = id;
        this.studentId = studentId;
        this.subjectId = subject;

    }

    public StudentSubject(UUID studentId, UUID subject) {
        this.id = UUID.randomUUID();
        this.studentId = studentId;
        this.subjectId = subject;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public UUID getSubject() {
        return subjectId;
    }

    public void setSubject(UUID subject) {
        this.subjectId = subject;
    }

    public void setMarks(Assessment assessment) {
        marks.add(assessment);
    }

    @Override
    public String toString() {
        return "StudentSubject{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", subject=" + subjectId +
                '}';
    }
}




