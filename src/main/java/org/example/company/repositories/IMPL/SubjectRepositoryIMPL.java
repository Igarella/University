package org.example.company.repositories.IMPL;

import org.example.company.DTO.Phone;
import org.example.company.DTO.Subject;
import org.example.company.repositories.SubjectRepository;
import org.postgresql.util.PGobject;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SubjectRepositoryIMPL implements SubjectRepository {

    private static String USER = "postgres";
    private static String PASSWORD = "1234";
    private static String URL = "jdbc:postgresql://localhost:5432/students";

    public static void main(String[] args) {
    }
    @Override
    public void addSubject(Subject subject) {
        try {
            String subjectName = subject.getNameSubject();
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO subjects (name_subject) values " +
                    "(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, subjectName);
            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Subject> getAllSubjects() {
        List<Subject> subjectList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String line = "select * from subjects";
            ResultSet resultSet = statement.executeQuery(line);
            while (resultSet.next()) {
                UUID id = UUID.fromString(resultSet.getString("id"));
                String subjectName = resultSet.getString("name_subject");
                Subject subject = new Subject(id, subjectName);
                subjectList.add(subject);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subjectList;
    }

    @Override
    public String getNameById(UUID SubjectId) {
        return getAllSubjects()
                .stream()
                .filter(e -> e.getId().equals(SubjectId))
                .map(e -> e.getNameSubject())
                .findFirst()
                .get();
    }

    @Override
    public Subject getSubjectById(UUID SubjectId) {
       return getAllSubjects()
                .stream()
                .filter(e -> e.getId().equals(SubjectId))
                .findFirst()
                .get();
    }
}
