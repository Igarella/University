package org.example.company.DTO;

import javax.sql.rowset.serial.SQLOutputImpl;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Specialization {
    private UUID specializationId;
    private String specializationName;
    private UUID facultyId;

    public UUID getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(UUID facultyId) {
        this.facultyId = facultyId;
    }

    public Specialization(String specializationName, UUID facultyId) {
        this.specializationId = UUID.randomUUID();
        this.specializationName = specializationName;
        this.facultyId = facultyId;
    }


    public Specialization(UUID specializationId, String specializationName, UUID facultyId) {
        this.specializationId = specializationId;
        this.specializationName = specializationName;
        this.facultyId = facultyId;

    }

    public UUID getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(UUID specializationId) {
        this.specializationId = specializationId;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "specializationId=" + specializationId +
                ", specializationName='" + specializationName + '\'' +
                '}';
    }

//    public static void main(String[] args) {
//        try {
//            SQLOutput sqlOutput = new SQLOutputImpl();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
