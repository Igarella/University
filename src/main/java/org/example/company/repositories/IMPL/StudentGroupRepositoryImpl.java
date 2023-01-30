package org.example.company.repositories.IMPL;

import org.example.company.DTO.StudentGroup;
import org.example.company.repositories.StudentGroupRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentGroupRepositoryImpl implements StudentGroupRepository {
    @Override
    public void addCurrentStudentToGroup(StudentGroup studentGroup) {
        try {
            FileWriter writer = new FileWriter("resources/StudentGroup.txt",true);
            writer.write(studentGroup.getId() + "," + studentGroup.getStudentId() + "," + studentGroup.getGroupId() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public StudentGroup getStudentGroupByStudentId(UUID studentId) {
       return getAllCurrentStudentGroup()
                .stream()
                .filter(e -> e.getStudentId().equals(studentId))
                .findFirst()
                .get();
    }


    @Override
    public List<StudentGroup> getAllCurrentStudentGroup() {
        List<StudentGroup> studentGroupList = new ArrayList<>();
        try {
            File file = new File("resources/StudentGroup.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] currentStudentGroups = line.split(",");
                StudentGroup studentGroup = new StudentGroup(UUID.fromString(currentStudentGroups[0]), UUID.fromString(currentStudentGroups[1]),  UUID.fromString(currentStudentGroups[2]));
                studentGroupList.add(studentGroup);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentGroupList;
    }
}
