package org.example.company.repositories;

import org.example.company.DTO.Teacher;

import java.util.List;
import java.util.UUID;

public interface TeacherRepository {
    List<Teacher> getAllTeachers();

    void addTeacher(Teacher teacher);

    Teacher getTeacherById(UUID teacherId);
}
