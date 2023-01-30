package org.example.company.DTO;
import java.util.UUID;

public class TimeTable {
    private UUID timeTableId;
    private UUID teacherId;
    private UUID subjectId;
    private int hours;

    public TimeTable(UUID teacherId, UUID subjectId, int hours){
        this.timeTableId = UUID.randomUUID();
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.hours = hours;
    }

    public TimeTable(UUID timeTableId, UUID teacherId, UUID subjectId, int hours) {
        this.timeTableId = timeTableId;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.hours = hours;
    }

    public UUID getTimeTableId() {
        return timeTableId;
    }

    public void setTimeTableId(UUID timeTableId) {
        this.timeTableId = timeTableId;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }

    public UUID getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(UUID subjectId) {
        this.subjectId = subjectId;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "TimeTables.txt{" +
                "timeTableId=" + timeTableId +
                ", teacherId=" + teacherId +
                ", subjectId=" + subjectId +
                ", hours=" + hours +
                '}';
    }
}
