package org.example.company.repositories.IMPL;

import org.example.company.DTO.Specialization;
import org.example.company.repositories.SpecializationRepository;
import org.postgresql.ds.common.PGObjectFactory;
import org.postgresql.util.PGobject;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SpecializationRepositoryIMPL implements SpecializationRepository {

    private static String USER = "postgres";
    private static String PASSWORD = "1234";
    private static String URL = "jdbc:postgresql://localhost:5432/students";

    public static void main(String[] args) {
    }
    
    @Override
    public List<Specialization> getAllSpecializations() {
        List<Specialization> specializationList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String line = "select * from specializations";
            ResultSet resultSet = statement.executeQuery(line);
            while (resultSet.next()) {
                UUID id = UUID.fromString(resultSet.getString("id"));
                String name = resultSet.getString("name");
                UUID facultyId = UUID.fromString(resultSet.getString("fk_faculty_id"));
                Specialization specialization = new Specialization(id, name, facultyId);
                specializationList.add(specialization);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return specializationList;
    }

    @Override
    public void addSpecialization(Specialization specialization) {
        try {
            UUID specializationId = specialization.getSpecializationId();
            String specializationName = specialization.getSpecializationName();
            UUID facultyId = specialization.getFacultyId();
            PGobject pgSpecializationId = new PGobject();
            pgSpecializationId.setType("uuid");
            pgSpecializationId.setValue(specializationId.toString());
            PGobject pgFacultyId = new PGobject();
            pgFacultyId.setType("uuid");
            pgFacultyId.setValue(facultyId.toString());
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO specializations (id, name, fk_faculty_id) values " +
                    "(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, pgSpecializationId);
            preparedStatement.setString(2, specializationName);
            preparedStatement.setObject(3, pgFacultyId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Specialization getSpecializationById(UUID specializationId) {
        return getAllSpecializations()
                .stream()
                .filter(e -> e.getSpecializationId().equals(specializationId))
                .findFirst()
                .get();
    }


}
