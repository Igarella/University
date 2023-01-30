package org.example.company.DTO;

import java.util.UUID;

public class StudentGroup {
    private UUID uuid;
    private UUID studentId;
    private UUID groupId;

    public StudentGroup(UUID studentId, UUID groupId) {
        this.uuid = UUID.randomUUID();
        this.studentId = studentId;
        this.groupId = groupId;
    }

    public StudentGroup(UUID uuid, UUID studentId, UUID groupId) {
        this.uuid = uuid;
        this.studentId = studentId;
        this.groupId = groupId;
    }

    public UUID getId() {
        return uuid;
    }

    public void setId(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "uuid=" + uuid +
                ", studentId=" + studentId +
                ", groupId=" + groupId +
                '}';
    }
}
