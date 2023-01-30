package org.example.company.repositories.IMPL;

import org.example.company.DTO.Subject;
import org.example.company.repositories.SubjectRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SubjectRepositoryIMPL implements SubjectRepository {
    @Override
    public void addSubject(Subject subject) {
        File file = new File("resources/Subjects.txt");
        try {
            FileWriter writer = new FileWriter(file,true);
            writer.write(subject.getId() + "," + subject.getNameSubject() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Subject> getAllSubjects() {
        List<Subject> subjectList = new ArrayList<>();
        try {
            File file = new File("resources/Subjects.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] subjectFields = line.split(",");
                Subject subject = new Subject(UUID.fromString(subjectFields[0]), subjectFields[1]);
                subjectList.add(subject);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return subjectList;
    }

    @Override
    public String getNameById(UUID SubjectId) {
        return getAllSubjects()
                .stream()
                .filter(e -> e.getId().equals(SubjectId))
                .map(e -> e.getNameSubject())
                .findFirst()
                .get();
    }

    @Override
    public Subject getSubjectById(UUID SubjectId) {
       return getAllSubjects()
                .stream()
                .filter(e -> e.getId().equals(SubjectId))
                .findFirst()
                .get();
    }
}
