package org.example.company.services.IMPL;

import org.example.company.DTO.TimeTable;
import org.example.company.repositories.IMPL.TimeTableRepositoryImpl;
import org.example.company.repositories.TimeTableRepository;
import org.example.company.services.TimeTableService;

import java.util.List;
import java.util.UUID;

public class TimeTableServiceImpl implements TimeTableService {
    @Override
    public List<TimeTable> getAllTimeTable() {
        TimeTableRepository repository = new TimeTableRepositoryImpl();
        return repository.getAllTimeTable();
    }

    @Override
    public void addTimeTable(TimeTable timeTable) {
        TimeTableRepository repository = new TimeTableRepositoryImpl();
        repository.addTimeTable(timeTable);
    }

    @Override
    public TimeTable getTimeTableBySubjectId(UUID subjectId) {
        TimeTableRepository repository = new TimeTableRepositoryImpl();
        return repository.getTimeTableBySubjectId(subjectId);
    }

    @Override
    public TimeTable getTimeTableById(UUID timeTableId) {
        TimeTableRepository repository = new TimeTableRepositoryImpl();
        return repository.getTimeTableById(timeTableId);
    }
}
