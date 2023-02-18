package org.example.company.repositories.IMPL;

import org.example.company.DTO.TimeTable;
import org.example.company.DTO.TimeTable;
import org.example.company.repositories.TimeTableRepository;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TimeTableRepositoryImpl implements TimeTableRepository {

    private static String USER = "postgres";
    private static String PASSWORD = "1234";
    private static String URL = "jdbc:postgresql://localhost:5432/students";

    public static void main(String[] args) {
        TimeTableRepositoryImpl timeTableRepository = new TimeTableRepositoryImpl();
        timeTableRepository.getAllTimeTable().forEach(System.out::println);
    }
    @Override
    public List<TimeTable> getAllTimeTable() {
        List<TimeTable> timeTableList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String line = "select * from timetable";
            ResultSet resultSet = statement.executeQuery(line);
            while (resultSet.next()) {
                UUID id = UUID.fromString(resultSet.getString("id"));
                UUID teacherId = UUID.fromString(resultSet.getString("fk_teacher_id"));
                UUID subjectId = UUID.fromString(resultSet.getString("fk_subject_id"));
                int hours = resultSet.getInt("hours");
                TimeTable timeTable = new TimeTable(id, teacherId, subjectId, hours);
                timeTableList.add(timeTable);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return timeTableList;
    }

    @Override
    public void addTimeTable(TimeTable timeTable) {
        try {
            FileWriter writer = new FileWriter("resources/TimeTables.txt",true);
            writer.write(timeTable.getTimeTableId() + "," + timeTable.getTimeTableId() + "," +
                   timeTable.getSubjectId() + "," + timeTable.getHours() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TimeTable getTimeTableById(UUID timeTableId) {
       return getAllTimeTable()
                .stream()
                .filter(e -> e.getTimeTableId().equals(timeTableId))
                .findFirst()
                .get();
    }

    @Override
    public TimeTable getTimeTableBySubjectId(UUID subjectId) {
       return getAllTimeTable()
                .stream()
                .filter(e -> e.getSubjectId().equals(subjectId))
                .findFirst()
                .get();
    }
}
