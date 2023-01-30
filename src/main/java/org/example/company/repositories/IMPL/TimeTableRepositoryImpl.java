package org.example.company.repositories.IMPL;

import org.example.company.DTO.TimeTable;
import org.example.company.repositories.TimeTableRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TimeTableRepositoryImpl implements TimeTableRepository {
    @Override
    public List<TimeTable> getAllTimeTable() {
        List<TimeTable> timeTableList = new ArrayList<>();
        try {
            File file = new File("resources/TimeTables.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] timeTablesFields = line.split(",");
                TimeTable timeTable = new TimeTable(UUID.fromString(timeTablesFields[0]), UUID.fromString(timeTablesFields[1]),
                        UUID.fromString(timeTablesFields[2]) ,Integer.parseInt(timeTablesFields[3]));
                timeTableList.add(timeTable);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return timeTableList;
    }

    @Override
    public void addTimeTable(TimeTable timeTable) {
        try {
            FileWriter writer = new FileWriter("resources/TimeTables.txt",true);
            writer.write(timeTable.getTimeTableId() + "," + timeTable.getTeacherId() + "," +
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
