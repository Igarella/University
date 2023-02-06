package org.example.company.repositories.IMPL;

import org.example.company.DTO.StudentSubject;
import org.example.company.DTO.StudentSubject;
import org.example.company.repositories.StudentSubjectRepository;
import org.postgresql.ds.common.PGObjectFactory;
import org.postgresql.jdbc.PgArray;
import org.postgresql.util.PGobject;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class StudentSubjectRepositoryIMPL implements StudentSubjectRepository {
    private static String USER = "postgres";
    private static String PASSWORD = "1234";
    private static String URL = "jdbc:postgresql://localhost:5432/students";

    public static void main(String[] args) {
        StudentSubjectRepositoryIMPL studentSubjectRepositoryIMPL = new StudentSubjectRepositoryIMPL();
        studentSubjectRepositoryIMPL.getAllStudentSubjects().forEach(System.out::println);
    }
    @Override
    public List<StudentSubject> getAllStudentSubjects() {
        List<StudentSubject> studentSubjectList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String line = "select * from student_subject";
            ResultSet resultSet = statement.executeQuery(line);
            while (resultSet.next()) {
                UUID id = UUID.fromString(resultSet.getString("id"));
                UUID studentId = UUID.fromString(resultSet.getString("fk_student_id"));
                UUID subjectId = UUID.fromString(resultSet.getString("fk_subject_id"));
                StudentSubject studentSubject = new StudentSubject(id, studentId, subjectId);
                studentSubjectList.add(studentSubject);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentSubjectList;
    }
    
    @Override
    public void addSubjectStudent(StudentSubject studentSubject) {
        try {
            UUID studentSubjectId = studentSubject.getId();
            UUID studentId = studentSubject.getStudentId();
            UUID subjectId = studentSubject.getSubjectId();
            PGobject pgStudentSubjectId = new PGobject();
            pgStudentSubjectId.setType("uuid");
            pgStudentSubjectId.setValue(studentSubjectId.toString());
            PGobject pgStudentIdObject = new PGobject();
            pgStudentIdObject.setType("uuid");
            pgStudentIdObject.setValue(studentId.toString());
            PGobject pgSubjectIdObject = new PGobject();
            pgSubjectIdObject.setType("uuid");
            pgSubjectIdObject.setValue(subjectId.toString());
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO student_subject (id, fk_student_id, fk_subject_id) values " +
                    "(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, pgStudentSubjectId);
            preparedStatement.setObject(2, pgStudentIdObject);
            preparedStatement.setObject(3, pgSubjectIdObject);
            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public StudentSubject getStudentSubjectByStudentSubjectId(UUID studentId, UUID subjectId) {
        return getAllStudentSubjects()
                .stream()
                .filter(e -> e.getStudentId().equals(studentId) && e.getSubjectId().equals(subjectId))
                .findFirst()
                .get();
    }

    @Override
    public List<StudentSubject> getStudentSubjectsByStudentId(UUID studentId) {
        return getAllStudentSubjects()
                .stream()
                .filter(e -> e.getStudentId().equals(studentId))
                .collect(Collectors.toList());
    }
}
