package org.example.company.repositories.IMPL;

import org.example.company.DTO.Student;
import org.example.company.repositories.StudentsRepository;
import org.postgresql.util.PGobject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
//@Repository
public class StudentsRepositoryIMPL implements StudentsRepository {

    private static String USER = "postgres";
    private static String PASSWORD = "1234";
    private static String URL = "jdbc:postgresql://localhost:5432/students";

    public static void main(String[] args) {
        StudentsRepository repository = new StudentsRepositoryIMPL();
        repository.getDeletedStudents().forEach(System.out::println);

    }


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
        Student student = null;
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String line = "select * from students where id = " + "'" + id + "'";
            ResultSet resultSet = statement.executeQuery(line);
            while (resultSet.next()) {
                UUID idStudent = UUID.fromString(resultSet.getString("id"));
                String firstName = resultSet.getString("first_name");
                String secondName = resultSet.getString("second_name");
                String birthDay = resultSet.getString("birth_day");
                boolean archived = resultSet.getBoolean("archived");
                student = new Student(idStudent, firstName, secondName, birthDay, archived);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public List<Student> getDeletedStudents() {
        List<Student> studentListDeleted = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String line = "select * from students where archived = true";
            ResultSet resultSet = statement.executeQuery(line);
            while (resultSet.next()) {
                UUID id = UUID.fromString(resultSet.getString("id"));
                String firstName = resultSet.getString("first_name");
                String secondName = resultSet.getString("second_name");
                String birthDay = resultSet.getString("birth_day");
                boolean archived = resultSet.getBoolean("archived");
                Student student = new Student(id, firstName, secondName, birthDay, archived);
                studentListDeleted.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentListDeleted;
    }
}

