package org.example.company.repositories.IMPL;

import org.example.company.DTO.Group;
import org.example.company.DTO.Phone;
import org.example.company.repositories.GroupRepository;
import org.postgresql.util.PGobject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroupRepositoryIMPL implements GroupRepository {

    private static String USER = "postgres";
    private static String PASSWORD = "1234";
    private static String URL = "jdbc:postgresql://localhost:5432/students";
    @Override
    public List<Group> getAllGroups() {
        List<Group> groupList = new ArrayList<>();
//        List<Group> groupList = new ArrayList<>();
//        try {
//            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            Statement statement = connection.createStatement();
//            String line = "select * from phones";
//            ResultSet resultSet = statement.executeQuery(line);
//            while (resultSet.next()) {
//                UUID id = UUID.fromString(resultSet.getString("id"));
//                String phoneNumber = resultSet.getString("phone_number");
//                String typePhone = resultSet.getString("type_phone");
//                UUID studentId = UUID.fromString(resultSet.getString("fk_student_id"));
//                Phone phone = new Phone(id, phoneNumber, typePhone, studentId);
//                phoneList.add(phone);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return groupList;
    }

    @Override
    public void addStudentToGroupBYStudentId(UUID studentId) {

    }

    @Override
    public Group getGroupById(UUID groupId) {
        return getAllGroups()
                .stream()
                .filter(e -> e.getGroupId().equals(groupId))
                .findFirst()
                .get();
    }

    @Override
    public void addGroup(Group group) {
        try {
//            new Group();
            UUID groupId = group.getGroupId();
            String groupName = group.getGroupName();
            UUID specializationId = group.getSpecializationId();
            PGobject pgGroupId = new PGobject();
            pgGroupId.setType("uuid");
            pgGroupId.setValue(groupId.toString());
            PGobject pgSpecializationId = new PGobject();
            pgSpecializationId.setType("uuid");
            pgSpecializationId.setValue(specializationId.toString());
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO groups (id, ) values " +
                    "(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, subjectName);
            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
