package org.example.company.repositories.IMPL;

import org.example.company.DTO.Assessment;
import org.example.company.DTO.Subject;
import org.example.company.repositories.AssessmentRepository;
import org.postgresql.util.PGobject;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public class AssessmentRepositoryIMPL implements AssessmentRepository {

    private static String USER = "postgres";
    private static String PASSWORD = "1234";
    private static String URL = "jdbc:postgresql://localhost:5432/students";

    public static void main(String[] args) {
        AssessmentRepositoryIMPL assessmentRepositoryIMPL = new AssessmentRepositoryIMPL();
        assessmentRepositoryIMPL.getAllAssessments().forEach(System.out::println);
    }

    @Override
    public void addAssessment(Assessment assessment) {
        try {
            UUID assessmentId = assessment.getId();
            UUID studentSubjectId = assessment.getStudentSubjectId();
            int mark = assessment.getMark();
            UUID topicId = assessment.getTopicId();
            PGobject pgAssessmentId = new PGobject();
            pgAssessmentId.setType("uuid");
            pgAssessmentId.setValue(assessmentId.toString());
            PGobject pgStudentSubjectId = new PGobject();
            pgStudentSubjectId.setType("uuid");
            pgStudentSubjectId.setValue(studentSubjectId.toString());
            PGobject pgTopicId = new PGobject();
            pgTopicId.setType("uuid");
            pgTopicId.setValue(topicId.toString());
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO assessments (id, fk_student_subject_id, mark, fk_topic_id) values " +
                    "(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, pgAssessmentId);
            preparedStatement.setObject(2, pgStudentSubjectId);
            preparedStatement.setInt(3, mark);
            preparedStatement.setObject(4, pgTopicId);
            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Assessment> getAssessmentsOfTopic(UUID studentSubjectId, UUID topicId) {
        return getAllAssessments()
                .stream()
                .filter(e -> e.getStudentSubjectId().equals(studentSubjectId) && e.getTopicId().equals(topicId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Assessment> getAssessmentsOfSubjectStudent(UUID studentSubjectId) {
        return getAllAssessments()
                .stream()
                .filter(e -> e.getStudentSubjectId().equals(studentSubjectId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Assessment> getAllAssessments() {
        List<Assessment> assessmentList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String line = "select * from assessments";
            ResultSet resultSet = statement.executeQuery(line);
            while (resultSet.next()) {
                UUID assessmentId = UUID.fromString(resultSet.getString("id"));
                UUID studentSubjectId = UUID.fromString(resultSet.getString("fk_student_subject_id"));
                int mark = resultSet.getInt("mark");
                UUID topicId = UUID.fromString(resultSet.getString("fk_topic_id"));
                Assessment assessment = new Assessment(assessmentId, studentSubjectId, mark, topicId);
                assessmentList.add(assessment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return assessmentList;
    }

    @Override
    public Assessment getAssessmentById(UUID assessmentId) {
        return getAllAssessments()
                .stream()
                .filter(e->e.getId().equals(assessmentId))
                .findFirst()
                .get();
    }
}

// TODO: 14.02.2023 correct assessment
