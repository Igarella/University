package org.example.company.DTO;

import java.util.UUID;

public class Teacher {
    private UUID teacherId;
    private String firstName;
    private String secondName;
    private UUID subjectId;

    public Teacher(String firstName, String secondName, UUID subjectId) {
        this.teacherId = UUID.randomUUID();
        this.firstName = firstName;
        this.secondName = secondName;
        this.subjectId = subjectId;
    }

    public Teacher(UUID teacherId, String firstName, String secondName, UUID subjectId) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.subjectId = subjectId;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public UUID getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(UUID subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", subjectId=" + subjectId +
                '}';
    }
}
