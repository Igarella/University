package org.example.company.repositories.IMPL;

import org.example.company.DTO.Teacher;
import org.example.company.repositories.TeacherRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TeacherRepositoryImpl implements TeacherRepository {
    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teacherList = new ArrayList<>();
        try {
            File file = new File("resources/Teachers.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] teachersFields = line.split(",");
                Teacher teacher = new Teacher(UUID.fromString(teachersFields[0]), teachersFields[1], teachersFields[2], UUID.fromString(teachersFields[3]));
                teacherList.add(teacher);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teacherList;    }

    @Override
    public void addTeacher(Teacher teacher) {
        try {
            FileWriter writer = new FileWriter("resources/Teachers.txt",true);
            writer.write(teacher.getTeacherId() + ","
                    + teacher.getFirstName() + ","
                    + teacher.getSecondName() + ","
                    + teacher.getSubjectId() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Teacher getTeacherById(UUID teacherId) {
        return getAllTeachers()
                .stream()
                .filter(e->e.getTeacherId().equals(teacherId))
                .findFirst()
                .get();
    }
}
