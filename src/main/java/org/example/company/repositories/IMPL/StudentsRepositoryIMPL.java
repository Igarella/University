package org.example.company.repositories.IMPL;

import org.example.company.DTO.Student;
import org.example.company.repositories.StudentsRepository;
import org.postgresql.util.PGobject;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class StudentsRepositoryIMPL implements StudentsRepository {

    private static String USER = "postgres";
    private static String PASSWORD = "1234";
    private static String URL = "jdbc:postgresql://localhost:5432/students";


    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String line = "select * from students";
            ResultSet resultSet = statement.executeQuery(line);
            while (resultSet.next()) {
                UUID id = UUID.fromString(resultSet.getString("id"));
                String firstName = resultSet.getString("first_name");
                String secondName = resultSet.getString("second_name");
                String birthDay = resultSet.getString("birth_day");
                boolean archived = resultSet.getBoolean("archived");
                Student student = new Student(id, firstName, secondName, birthDay, archived);
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public void addStudent(Student student) {
        try {
            String firstName = student.getFirstName();
            String secondName = student.getSecondName();
            String birthDay = student.getBirthday();
            boolean archived = student.isArchived();
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO students (first_name, second_name, birth_day, archived) values " +
                    "(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, secondName);
            preparedStatement.setString(3, birthDay);
            preparedStatement.setBoolean(4, archived);
//            preparedStatement.setString(2, "myname");
//            preparedStatement.setString(3, "4321");
            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteStudent(UUID uuid) {
        try {
            PGobject toInsertUUID = new PGobject();
            toInsertUUID.setType("uuid");
            toInsertUUID.setValue(uuid.toString());
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "update students set archived = false where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, toInsertUUID);
            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student getStudentById(UUID id) {
        return getAllStudents()
                .stream()
                .filter(e-> e.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public List<Student> getDeletedStudents() {
        return getAllStudents()
                .stream()
                .filter(Student::isArchived)
                .collect(Collectors.toList());
    }
}

