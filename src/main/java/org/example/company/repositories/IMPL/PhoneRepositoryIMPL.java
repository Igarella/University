package org.example.company.repositories.IMPL;

import org.example.company.DTO.Phone;
import org.example.company.DTO.Student;
import org.example.company.repositories.PhonesRepository;
import org.postgresql.util.PGobject;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PhoneRepositoryIMPL implements PhonesRepository {
    private static String USER = "postgres";
    private static String PASSWORD = "1234";
    private static String URL = "jdbc:postgresql://localhost:5432/students";

    @Override
    public void addPhone(Phone phone) {
        try {
            String number = phone.getNumberPhone();
            String type = phone.getTypePhone();
            UUID studentId = phone.getStudentId();
            PGobject uuidObject = new PGobject();
            uuidObject.setType("uuid");
            uuidObject.setValue(studentId.toString());
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO phones (phone_number, type_phone, fk_student_id) values " +
                    "(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, number);
            preparedStatement.setString(2, type);
            preparedStatement.setObject(3, uuidObject);
            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePhone(UUID uuid) {
        try {
            PGobject uuidObject = new PGobject();
            uuidObject.setType("uuid");
            uuidObject.setValue(uuid.toString());
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "delete from phones where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, uuidObject);
            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Phone> getPhoneByStudentId(UUID studentId) {
        List<Phone> phoneList = getAllPhones();
        return phoneList
                .stream()
                .filter(e -> e.getStudentId().equals(studentId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Phone> getAllPhones() {
        List<Phone> phoneList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String line = "select * from phones";
            ResultSet resultSet = statement.executeQuery(line);
            while (resultSet.next()) {
                UUID id = UUID.fromString(resultSet.getString("id"));
                String phoneNumber = resultSet.getString("phone_number");
                String typePhone = resultSet.getString("type_phone");
                UUID studentId = UUID.fromString(resultSet.getString("fk_student_id"));
                Phone phone = new Phone(id, phoneNumber, typePhone, studentId);
                phoneList.add(phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phoneList;
    }
}
