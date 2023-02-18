package org.example.company.repositories.IMPL;

import org.example.company.DTO.Group;
import org.example.company.repositories.GroupRepository;
import org.postgresql.util.PGobject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroupRepositoryIMPL implements GroupRepository {

    private static String USER = "postgres";
    private static String PASSWORD = "1234";
    private static String URL = "jdbc:postgresql://localhost:5432/students";

    public static void main(String[] args) {
        GroupRepository repository = new GroupRepositoryIMPL();
//        repository.addGroup(new Group("15PGSz - 4tex", UUID.fromString("cf353753-12cd-4ffd-9313-db2554e2434c")));
        System.out.println(repository.getGroupById(UUID.fromString("e7a0093f-b6a8-4451-8a94-f97eda4cb855")));

    }
    @Override
    public List<Group> getAllGroups() {
        List<Group> groupList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String line = "select * from groups";
            ResultSet resultSet = statement.executeQuery(line);
            while (resultSet.next()) {
                UUID id = UUID.fromString(resultSet.getString("id"));
                String groupName = resultSet.getString("group_name");
                UUID specializationId = UUID.fromString(resultSet.getString("fk_specialization_id"));
                Group group = new Group(id, groupName, specializationId);
                groupList.add(group);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groupList;
    }

    @Override
    public Group getGroupById(UUID groupId) {
        Group group = null;
            try {
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                String sql = "select * from groups where id = " + "'" + groupId + "'";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    UUID id = UUID.fromString(resultSet.getString("id"));
                    String groupName = resultSet.getString("group_name");
                    UUID specializationId = UUID.fromString(resultSet.getString("fk_specialization_id"));
                    group = new Group(id, groupName, specializationId);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return group;
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
            String sql = "INSERT INTO groups (id, group_name, fk_specialization_id) values " +
                    "(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, pgGroupId);
            preparedStatement.setString(2, groupName);
            preparedStatement.setObject(3, pgSpecializationId);
            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
