package org.example.company.repositories.IMPL;

import org.example.company.DTO.Faculty;
import org.example.company.DTO.Phone;
import org.example.company.repositories.FacultyRepository;
import org.postgresql.util.PGobject;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FacultyRepositoryImpl implements FacultyRepository {

    private static String USER = "postgres";
    private static String PASSWORD = "1234";
    private static String URL = "jdbc:postgresql://localhost:5432/students";


    @Override
    public void addFaculty(Faculty faculty) {
            try {
                String facultyName = faculty.getFacultyName();
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                String sql = "INSERT INTO faculties (name) values " +
                        "(?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, facultyName);
                int rows = preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    @Override
    public List<Faculty> getAllFaculties() {
        List<Faculty> facultyList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String line = "select * from faculties";
            ResultSet resultSet = statement.executeQuery(line);
            while (resultSet.next()) {
                UUID facultyId = UUID.fromString(resultSet.getString("id"));
                String facultyName = resultSet.getString("name");
                Faculty faculty = new Faculty(facultyId, facultyName);
                facultyList.add(faculty);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return facultyList;
    }

    @Override
    public Faculty getFacultyById(UUID facultyId) {
        return getAllFaculties()
                .stream()
                .filter(e->e.getFacultyId().equals(facultyId))
                .findFirst()
                .get();
    }
}
