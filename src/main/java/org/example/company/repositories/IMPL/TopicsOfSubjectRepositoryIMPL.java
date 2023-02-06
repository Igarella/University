package org.example.company.repositories.IMPL;

import org.example.company.DTO.Topic;
import org.example.company.DTO.Topic;
import org.example.company.repositories.TopicsOfSubjectRepository;
import org.postgresql.util.PGobject;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TopicsOfSubjectRepositoryIMPL implements TopicsOfSubjectRepository {
    private static String USER = "postgres";
    private static String PASSWORD = "1234";
    private static String URL = "jdbc:postgresql://localhost:5432/students";
    @Override
    public List<Topic> getAllTopics() {
        List<Topic> topicList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String line = "select * from topics";
            ResultSet resultSet = statement.executeQuery(line);
            while (resultSet.next()) {
                UUID id = UUID.fromString(resultSet.getString("id"));
                String topicName = resultSet.getString("name");
                UUID subjectId = UUID.fromString(resultSet.getString("fk_subject_id"));
                Topic topic = new Topic(id, topicName, subjectId);
                topicList.add(topic);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return topicList;
    }

    public static void main(String[] args) {
    }

    @Override
    public void addTopic(Topic topic) {
        try {
            String topicName = topic.getName();
            UUID subjectId = topic.getSubjectId();
            UUID topicId = topic.getId();
            PGobject subjectIdObject = new PGobject();
            subjectIdObject.setType("uuid");
            subjectIdObject.setValue(subjectId.toString());
            PGobject topicIdObject = new PGobject();
            topicIdObject.setType("uuid");
            topicIdObject.setValue(topicId.toString());
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO topics (id, name, fk_subject_id) values " +
                    "(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, topicIdObject);
            preparedStatement.setString(2, topicName);
            preparedStatement.setObject(3, subjectIdObject);
            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Topic> getTopicsBySubjectId(UUID subjectId) {
        return getAllTopics()
                .stream()
                .filter(e -> e.getSubjectId().equals(subjectId))
                .collect(Collectors.toList());
    }
    
}
