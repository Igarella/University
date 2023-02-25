package org.example.company.services.IMPL;

import lombok.AllArgsConstructor;
import org.example.company.DTO.*;
import org.example.company.JPARepository.StudentRepositoryJPA;
import org.example.company.entities.StudentEntity;
import org.example.company.repositories.*;
import org.example.company.repositories.IMPL.*;
import org.example.company.services.*;
import org.example.company.transformer.StudentEntityToStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Component
//@AllArgsConstructor
//@Autowired
public class StudentsServiceIMPL implements StudentsService {
    private StudentRepositoryJPA repositoryJpa;
    private StudentEntityToStudent transformer;

    public StudentsServiceIMPL(StudentRepositoryJPA repositoryJpa, StudentEntityToStudent transformer) {
        this.repositoryJpa = repositoryJpa;
        this.transformer = transformer;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentsList = new ArrayList<>();
//        StudentsRepository repository = new StudentsRepositoryIMPL();
        for (StudentEntity allStudent : repositoryJpa.findAll()) {
            Student student = transformer.transform(allStudent);
            studentsList.add(student);
        }
        return studentsList;
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
//        FacultyService facultyService = new FacultyServiceIMPL();
//        Faculty faculty = facultyService.getFacultyById(group.getFacultyId());
//        student.setFacultyName(faculty.getFacultyName());
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


