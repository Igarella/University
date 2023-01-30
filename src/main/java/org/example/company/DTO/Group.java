package org.example.company.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group {
    private UUID groupId;
    private UUID facultyId;
    private String groupName;
    private UUID specializationId;
    private List<Student> studentList = new ArrayList<>();


    public Group(UUID facultyId, String groupName, UUID specializationId) {
        this.groupId = UUID.randomUUID();
        this.facultyId = facultyId;
        this.groupName = groupName;
        this.specializationId = specializationId;
    }

    public Group(UUID groupId, UUID facultyId, String groupName, UUID specializationId) {
        this.groupId = groupId;
        this.facultyId = facultyId;
        this.groupName = groupName;
        this.specializationId = specializationId;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public UUID getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(UUID facultyId) {
        this.facultyId = facultyId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public UUID getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(UUID specializationId) {
        this.specializationId = specializationId;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", facultyId=" + facultyId +
                ", groupName='" + groupName + '\'' +
                ", specializationId=" + specializationId +
                ", studentList=" + studentList +
                '}';
    }
}



