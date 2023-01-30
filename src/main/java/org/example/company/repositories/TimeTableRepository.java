package org.example.company.repositories;

import org.example.company.DTO.TimeTable;

import java.util.List;
import java.util.UUID;

public interface TimeTableRepository {
    List<TimeTable> getAllTimeTable();

    void addTimeTable(TimeTable timeTable);

    TimeTable getTimeTableById(UUID timeTableId);

    TimeTable getTimeTableBySubjectId(UUID subjectId);

}
