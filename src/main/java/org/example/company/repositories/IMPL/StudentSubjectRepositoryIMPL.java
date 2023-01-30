package org.example.company.repositories.IMPL;

import org.example.company.DTO.StudentSubject;
import org.example.company.repositories.StudentSubjectRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class StudentSubjectRepositoryIMPL implements StudentSubjectRepository {
    @Override
    public void addSubjectStudent(StudentSubject studentSubject) {
        try {
            FileWriter writer = new FileWriter("resources/StudentSubjects.txt",true);
            writer.write(studentSubject.getId() + "," + studentSubject.getStudentId()
                    + "," + studentSubject.getSubject() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<StudentSubject> getAllStudentSubjects() {
        List<StudentSubject> studentSubjectList = new ArrayList<>();
        try {
            File file = new File("resources/StudentSubjects.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] studentSubjectsFields = line.split(",");
                StudentSubject studentSubject = new StudentSubject(UUID.fromString(studentSubjectsFields[0]),
                        UUID.fromString(studentSubjectsFields[1]), UUID.fromString(studentSubjectsFields[2]));
                studentSubjectList.add(studentSubject);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentSubjectList;
    }

    @Override
    public StudentSubject getStudentSubjectByStudentSubjectId(UUID studentId, UUID subjectId) {
        return getAllStudentSubjects()
                .stream()
                .filter(e -> e.getStudentId().equals(studentId) && e.getSubject().equals(subjectId))
                .findFirst()
                .get();
    }

    @Override
    public List<StudentSubject> getStudentSubjectsByStudentId(UUID studentId) {
        return getAllStudentSubjects()
                .stream()
                .filter(e -> e.getStudentId().equals(studentId))
                .collect(Collectors.toList());
    }


}
