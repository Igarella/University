package org.example.company.repositories.IMPL;

import org.example.company.DTO.Student;
import org.example.company.repositories.StudentsRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class StudentsRepositoryIMPL implements StudentsRepository {

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        try {

            File file = new File("resources/Students.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] studentFromFile = line.split(",");
                Student student = new Student(UUID.fromString(studentFromFile[0]), studentFromFile[1], studentFromFile[2], studentFromFile[3], Boolean.parseBoolean(studentFromFile[4]));
                studentList.add(student);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void addStudent(Student student) {
        try {
            FileWriter writer = new FileWriter("resources/Students.txt",true);
                writer.write(student.getId() + "," + student.getFirstName() + "," + student.getSecondName() + "," + student.getBirthday() + "," + student.isArchived() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(UUID uuid) {
        List<Student> studentList = getAllStudents();
        studentList
                .stream()
                .filter(e -> e.getId().equals(uuid))
                .findFirst()
                .get().setArchived(true);
        try {
            FileWriter writer = new FileWriter("resources/Students.txt");
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Student student : studentList) {
            addStudent(student);
        }


    }

    @Override
    public Student getStudentById(UUID id) {
        return getAllStudents()
                .stream()
                .filter(e-> e.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public List<Student> getDeletedStudents() {
        return getAllStudents()
                .stream()
                .filter(Student::isArchived)
                .collect(Collectors.toList());
    }
}

