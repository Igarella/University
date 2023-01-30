package org.example.company.repositories.IMPL;

import org.example.company.DTO.Faculty;
import org.example.company.repositories.FacultyRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FacultyRepositoryImpl implements FacultyRepository {
    @Override
    public void addFaculty(Faculty faculty) {
        try {
            FileWriter writer = new FileWriter("resources/Faculties.txt",true);
            writer.write(faculty.getFacultyId()+ "," + faculty.getFacultyName() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Faculty> getAllFaculties() {
        List<Faculty> facultyList = new ArrayList<>();
        try {
            File file = new File("resources/Faculties.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] facultyFields = line.split(",");
                Faculty faculty = new Faculty(UUID.fromString(facultyFields[0]), facultyFields[1]);
                facultyList.add(faculty);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facultyList;
    }

    @Override
    public Faculty getFacultyById(UUID facultyId) {
        return getAllFaculties()
                .stream()
                .filter(e->e.getFacultyId().equals(facultyId))
                .findFirst()
                .get();
    }
}
