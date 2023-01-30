package org.example.company.services.IMPL;

import org.example.company.DTO.*;
import org.example.company.repositories.*;
import org.example.company.repositories.IMPL.*;
import org.example.company.services.*;

import java.util.List;
import java.util.UUID;

public class StudentsServiceIMPL implements StudentsService {
    @Override
    public List<Student> getAllStudents() {
        StudentsRepository repository = new StudentsRepositoryIMPL();
        return repository.getAllStudents();
    }

    @Override
    public void addStudent(Student student) {
        StudentsRepository repository = new StudentsRepositoryIMPL();
        repository.addStudent(student);
    }

    @Override
    public void deleteStudent(UUID uuid) {
        StudentsRepository repository = new StudentsRepositoryIMPL();
        repository.deleteStudent(uuid);
    }


    @Override
    public Student getStudentById(UUID id) {
        StudentsRepository repository = new StudentsRepositoryIMPL();
        Student student = repository.getStudentById(id);
        ComplexStudentService complexStudentService = new ComplexStudentServiceImpl();
        ComplexId complexId = complexStudentService.getComplexIdByStudentId(student.getId());
        GroupService groupService = new GroupServiceIMPL();
        Group group = groupService.getGroupById(complexId.getGroupId());
        student.setGroupName(group.getGroupName());
        FacultyService facultyService = new FacultyServiceIMPL();
        Faculty faculty = facultyService.getFacultyById(group.getFacultyId());
        student.setFacultyName(faculty.getFacultyName());
        SpecializationService specializationService = new SpecializationServiceIMPL();
        Specialization specialization = specializationService.getSpecializationById(group.getSpecializationId());
        student.setSpecializationName(specialization.getSpecializationName());
//        StudentSpecializationRepository studentSpecializationRepository = new StudentSpecializationRepositoryIMPL();
//        List<StudentSubject> studentSpecializationList = studentSpecializationRepository.getAllStudentSpecializations();//достал лист ВСЕХ специализаций
//        List<Subject> subjects = new ArrayList<>();
//        for (StudentSubject studentSpecialization : studentSpecializationList) {
//            UUID subjectId = studentSpecialization.getSpecialization();
//            SubjectRepository subjectRepository = new SubjectRepositoryIMPL();
//           String name = subjectRepository.getNameById(subjectId);
//            Subject subject = new Subject(subjectId, name);
//            subjects.add(subject);
//        }
//        student.setSubjects(subjects);
        return student;
    }

    @Override
    public List<Student> getDeletedStudents() {
        StudentsRepository repository = new StudentsRepositoryIMPL();
        return repository.getDeletedStudents();
    }
}


