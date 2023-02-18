package org.example.company.repositories.IMPL;

import org.example.company.DTO.Teacher;
import org.example.company.repositories.TeacherRepository;
import org.postgresql.util.PGobject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TeacherRepositoryImpl implements TeacherRepository {

    private static String USER = "postgres";
    private static String PASSWORD = "1234";
    private static String URL = "jdbc:postgresql://localhost:5432/students";

    public static void main(String[] args) {
        TeacherRepositoryImpl teacherRepository = new TeacherRepositoryImpl();
        teacherRepository.getAllTeachers().forEach(System.out::println);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teacherList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String line = "select * from teachers";
            ResultSet resultSet = statement.executeQuery(line);
            while (resultSet.next()) {
                UUID id = UUID.fromString(resultSet.getString("id"));
                String firstName = resultSet.getString("first_name");
                String thirdName = resultSet.getString("third_name");
                Teacher teacher = new Teacher(id, firstName, thirdName);
                teacherList.add(teacher);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teacherList;
    }

        @Override
        public void addTeacher (Teacher teacher){
            try {
                String firstName = teacher.getFirstName();
                String thirdName = teacher.getThirdName();
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                String sql = "INSERT INTO teachers (first_name, third_name) values " +
                        "(?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, thirdName);
                int rows = preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public Teacher getTeacherById (UUID teacherId){
            return getAllTeachers()
                    .stream()
                    .filter(e -> e.getTeacherId().equals(teacherId))
                    .findFirst()
                    .get();
        }
}
// TODO: 13.02.2023 finish getTeacherById