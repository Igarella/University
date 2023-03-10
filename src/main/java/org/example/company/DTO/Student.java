package org.example.company.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;
@Component
@RequiredArgsConstructor
@Data
public class Student implements Serializable {
    @NonNull
    private UUID id;
    @NonNull
    private String firstName;
    @NonNull
    private String secondName;
    @NonNull
    private boolean archived = false;
    private UUID groupId;
    private UUID facultyId;
    private String facultyName;
    private String groupName;
    private String birthday;
    private String specializationName;
    private List<Phone> phoneStudent;
    private List<Email> emailsStudent;
    private List<Subject> subjects;
    private List<Assessment> assessments = new ArrayList<>();

    public Student() {

    }

    public Student(UUID id, String firstName, String secondName, String birthDay, boolean archived) {

    }

//    public List<Assessment> getAssessments() {
//        return assessments;
//    }
//
//    public void setAssessments(List<Assessment> assessments) {
//        this.assessments = assessments;
//    }
//
//    public List<Subject> getSpecializations() {
//        return subjects;
//    }
//
//    public void setSpecializations(List<Subject> subjects) {
//        this.subjects = subjects;
//    }
//
//    public List<Phone> getPhoneStudent() {
//        return phoneStudent;
//    }
//
//    public void setPhoneStudent(List<Phone> phoneStudent) {
//        this.phoneStudent = phoneStudent;
//    }
//
//    public List<Email> getEmailsStudent() {
//        return emailsStudent;
//    }
//
//    public void setEmailsStudent(List<Email> emailsStudent) {
//        this.emailsStudent = emailsStudent;
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getSecondName() {
//        return secondName;
//    }
//
//    public void setSecondName(String secondName) {
//        this.secondName = secondName;
//    }
//
//    public boolean isArchived() {
//        return archived;
//    }
//
//    public void setArchived(boolean archived) {
//        this.archived = archived;
//    }
//
//    public Student(UUID id, String firstName, String secondName) {
//        this.id = id;
//        this.firstName = firstName;
//        this.secondName = secondName;
//    }
//
//    public Student(String firstName, String secondName) {
//        this.id = UUID.randomUUID();
//        this.firstName = firstName;
//        this.secondName = secondName;
//    }
//
//    public Student(String firstName, String secondName, boolean archived) {
//        this.id = UUID.randomUUID();
//        this.firstName = firstName;
//        this.secondName = secondName;
//        this.archived = archived;
//    }
//
//    public Student(UUID id, String firstName, String secondName, boolean archived) {
//        this.id = id;
//        this.firstName = firstName;
//        this.secondName = secondName;
//        this.archived = archived;
//    }
//
//    public Student(UUID id, String firstName, String secondName, String birthday, boolean archived) {
//        this.id = id;
//        this.firstName = firstName;
//        this.secondName = secondName;
//        this.archived = archived;
//        this.birthday = birthday;
//    }
//
//    public UUID getGroupId() {
//        return groupId;
//    }
//
//    public void setGroupId(UUID groupId) {
//        this.groupId = groupId;
//    }
//
//    public List<Subject> getSubjects() {
//        return subjects;
//    }
//
//    public void setSubjects(List<Subject> subjects) {
//        this.subjects = subjects;
//    }
//
////    public UUID getFacultyId() {
////        return facultyId;
////    }
////
////    public void setFacultyId(UUID facultyId) {
////        this.facultyId = facultyId;
////    }
//
//    public String getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(String birthday) {
//        this.birthday = birthday;
//    }
//
//    public String getFacultyName() {
//        return facultyName;
//    }
//
//    public void setFacultyName(String facultyName) {
//        this.facultyName = facultyName;
//    }
//
//    public String getGroupName() {
//        return groupName;
//    }
//
//    public void setGroupName(String groupName) {
//        this.groupName = groupName;
//    }
//
//    public String getSpecializationName() {
//        return specializationName;
//    }
//
//    public void setSpecializationName(String specializationName) {
//        this.specializationName = specializationName;
//    }
//
////    @Override
////    public String toString() {
////        return "Student{" +
////                "id=" + id +
////                ", firstName='" + firstName + '\'' +
////                ", secondName='" + secondName + '\'' +
////                ", archived=" + archived +
////                ", groupId=" + groupId +
////                ", phoneStudent=" + phoneStudent +
////                ", emailsStudent=" + emailsStudent +
////                ", subjects=" + subjects +
////                ", assessments=" + assessments +
////                '}';
////    }


    @Override
    public String toString() {
        return "??????????????:" + getFirstName() + " " + getSecondName() + ", " +
                "???????? ????????????????:" + getBirthday() + ", " +
                "??????????????????????????:" + getSpecializationName() + ", " +
                "????????????:" + getGroupName() + ", " +
                "??????????????????:" + getFacultyName();
    }
}
