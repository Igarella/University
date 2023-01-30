package org.example.company.repositories.IMPL;

import org.example.company.DTO.ComplexId;
import org.example.company.repositories.ComplexStudentRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ComplexStudentRepositoryImpl implements ComplexStudentRepository {
    @Override
    public List<ComplexId> getAllComplexStudents() {
        List<ComplexId> complexIdList = new ArrayList<>();
        try {
            File file = new File("resources/ComplexId.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] complexStudentFields = line.split(",");
                ComplexId complexId = new ComplexId(UUID.fromString(complexStudentFields[0]), UUID.fromString(complexStudentFields[1]),
                        UUID.fromString(complexStudentFields[2]), UUID.fromString(complexStudentFields[3]), UUID.fromString(complexStudentFields[4]));
                complexIdList.add(complexId);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
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
