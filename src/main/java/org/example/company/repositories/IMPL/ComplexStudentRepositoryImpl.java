package org.example.company.repositories.IMPL;

import org.example.company.DTO.ComplexId;
import org.example.company.repositories.ComplexStudentRepository;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ComplexStudentRepositoryImpl implements ComplexStudentRepository {
    private static String USER = "postgres";
    private static String PASSWORD = "1234";
    private static String URL = "jdbc:postgresql://localhost:5432/students";

    public static void main(String[] args) {
        List<ComplexId> complexIdList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String sql = "select name, name_table\n" +
                    "from mytable1\n" +
                    "inner join mytable2 on mytable1.id = Mytable2.fk_mytable1_id\n, " +
                    "order by mytable1.id;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String name1 = resultSet.getString("name");
                String name2 = resultSet.getString("name_table");
                System.out.println(name1 + name2);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ComplexId> getAllComplexStudents() {
        List<ComplexId> complexIdList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String sql = "select * from complex";
            ResultSet resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return complexIdList;
    }

    @Override
    public ComplexId getComplexIdByStudentId(UUID studentId) {
        for (ComplexId allComplexStudent : getAllComplexStudents()) {
            if (allComplexStudent.getStudentId().equals(studentId)) {
                return allComplexStudent;
            }
        }
        return null;
    }

    @Override
    public void addComplexId(ComplexId complexId) {
        try {
            FileWriter writer = new FileWriter("resources/ComplexId.txt",true);
            writer.write(complexId.getId() + "," + complexId.getStudentId() + "," + complexId.getFacultyId() + ","
                    + complexId.getGroupId() + "," + complexId.getSpecializationId() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
