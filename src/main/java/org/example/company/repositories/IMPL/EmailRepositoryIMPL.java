package org.example.company.repositories.IMPL;

import org.example.company.DTO.Email;
import org.example.company.DTO.Email;
import org.example.company.repositories.EmailRepository;
import org.postgresql.core.CommandCompleteParser;
import org.postgresql.core.SqlCommand;
import org.postgresql.util.PGobject;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EmailRepositoryIMPL implements EmailRepository {

    private static String USER = "postgres";
    private static String PASSWORD = "1234";
    private static String URL = "jdbc:postgresql://localhost:5432/students";


    @Override
    public List<Email> getAllEmails() {
        List<Email> emailList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String line = "select * from emails";
            ResultSet resultSet = statement.executeQuery(line);
            while (resultSet.next()) {
                UUID id = UUID.fromString(resultSet.getString("id"));
                String email = resultSet.getString("email");
                UUID studentId = UUID.fromString(resultSet.getString("fk_student_id"));
                Email emailObject = new Email(id, email, studentId);
                emailList.add(emailObject);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return emailList;
    }

    @Override
    public void writeEmails(List<Email> list) {

    }

    @Override
    public void addEmail(Email email) {
        try {
            String emailName = email.getEmail();
            UUID emailStudentId = email.getStudentId();
            PGobject uuidObject = new PGobject();
            uuidObject.setType("uuid");
            uuidObject.setValue(emailStudentId.toString());
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO emails (email, fk_student_id) values " +
                    "(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, emailName);
            preparedStatement.setObject(2, uuidObject);
            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmail(UUID uuid) {
        try {
            PGobject uuidObject = new PGobject();
            uuidObject.setType("uuid");
            uuidObject.setValue(uuid.toString());
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "delete from emails where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, uuidObject);
            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Email> getEmailByStudentId(UUID id) {
        return getAllEmails()
                .stream()
                .filter(e -> e.getStudentId().equals(id))
                .collect(Collectors.toList());
    }
}

// TODO: 04.02.2023 реализован метод удаления email нужно ли его реализовывать в меню?
// TODO: 04.02.2023 getEmailByStudentId нужно ли у всех подобных методов поменять логику на работу с БД и обязательно ли возвращать Лист или один объект?
