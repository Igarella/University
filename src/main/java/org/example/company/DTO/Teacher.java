package org.example.company.DTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
@Data
public class Teacher {
    private UUID teacherId;
    private String firstName;
    private String thirdName;

    public Teacher(String firstName, String thirdName) {
        this.firstName = firstName;
        this.thirdName = thirdName;
    }

    public Teacher(UUID teacherId, String firstName, String thirdName) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.thirdName = thirdName;
    }
}
