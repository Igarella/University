package org.example.company.DTO;

import java.util.UUID;

public class ComplexId {
    private UUID id;
    private UUID studentId;
    private UUID facultyId;
    private UUID groupId;
    private UUID specializationId;

    public ComplexId(UUID studentId, UUID facultyId, UUID groupId, UUID specializationId) {
        this.id = UUID.randomUUID();
        this.studentId = studentId;
        this.facultyId = facultyId;
        this.groupId = groupId;
        this.specializationId = specializationId;

    }

    public ComplexId(UUID complexStudentId, UUID studentId, UUID facultyId, UUID groupId, UUID specializationId) {
        this.id = complexStudentId;
        this.studentId = studentId;
        this.facultyId = facultyId;
        this.groupId = groupId;
        this.specializationId = specializationId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID complexStudentId) {
        this.id = complexStudentId;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public UUID getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(UUID facultyId) {
        this.facultyId = facultyId;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public UUID getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(UUID specializationId) {
        this.specializationId = specializationId;
    }

    @Override
    public String toString() {
        return "ComplexId{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", facultyId=" + facultyId +
                ", groupId=" + groupId +
                ", specializationId=" + specializationId +
                '}';
    }
}
