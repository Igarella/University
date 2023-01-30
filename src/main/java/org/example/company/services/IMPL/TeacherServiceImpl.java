package org.example.company.services.IMPL;

import org.example.company.DTO.Teacher;
import org.example.company.repositories.IMPL.TeacherRepositoryImpl;
import org.example.company.repositories.TeacherRepository;
import org.example.company.services.TeacherService;

import java.util.List;
import java.util.UUID;

public class TeacherServiceImpl implements TeacherService {
    @Override
    public List<Teacher> getAllTeachers() {
        TeacherRepository repository = new TeacherRepositoryImpl();
        repository.getAllTeachers();
        return null;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        TeacherRepository repository = new TeacherRepositoryImpl();
        repository.addTeacher(teacher);
    }

    @Override
    public Teacher getTeacherById(UUID teacherId) {
        TeacherRepository repository = new TeacherRepositoryImpl();
        return repository.getTeacherById(teacherId);
    }
}
