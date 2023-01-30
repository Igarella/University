package org.example.company.services;

import org.example.company.DTO.TimeTable;

import java.util.List;
import java.util.UUID;

public interface TimeTableService {
    List<TimeTable> getAllTimeTable();

    void addTimeTable(TimeTable timeTable);

    TimeTable getTimeTableBySubjectId(UUID subjectId);

    TimeTable getTimeTableById(UUID timeTableId);

}
