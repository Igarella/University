package org.example.company.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Faculty {
    private UUID facultyId;
    private String facultyName;

    public Faculty(String facultyName) {
        this.facultyId = UUID.randomUUID();
        this.facultyName = facultyName;
    }

    public Faculty(UUID facultyId, String facultyName) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;

    }

    public UUID getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(UUID facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }


    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", facultyName='" + facultyName + '\'' +
                '}';
    }
}
