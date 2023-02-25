package org.example.company;

import org.example.company.DTO.*;
import org.example.company.repositories.StudentsRepository;
import org.example.company.services.*;
import org.example.company.services.IMPL.*;
import org.example.company.services.StudentsService;

import java.util.Scanner;
import java.util.UUID;

public class Menu {
     public static void startMenu() {
//        int menu;
//        Scanner in = new Scanner(System.in);
//        MenuProgram.menuProgram();
//        do {
//            menu = in.nextInt();
//            switch (menu) {
//                case 1 -> {
//                    StudentsService studentsService = new StudentsServiceIMPL();
//                    studentsService.getAllStudents().forEach(System.out::println);
//                }
//                case 11 -> {
//                    StudentsService studentsService = new StudentsServiceIMPL();
//                    studentsService.getDeletedStudents().forEach(System.out::println);
//                }
//                case 2 -> {
//                    System.out.println("Введите имя студента");
//                    String name = in.next();
//                    System.out.println("Введите фамилию");
//                    String secondName = in.next();
//                    System.out.println("Введите день рождения");
//                    String birthday = in.next();
//                    Student student = new Student(name, secondName);
//                    student.setBirthday(birthday);
//                    StudentsService studentsService = new StudentsServiceIMPL();
//                    studentsService.addStudent(student);
////                    studentsService.getAllStudents().forEach(System.out::println);
//                }
//                case 21 -> {
//                    System.out.println("Введите id студента");
//                    UUID studentId = UUID.fromString(in.next());
//                    System.out.println("Введите id группы");
//                    UUID groupId = UUID.fromString(in.next());
//                    StudentGroup studentGroup = new StudentGroup(studentId, groupId);
//                    StudentGroupService service = new StudentGroupServiceImpl();
//                    service.addCurrentStudentToGroup(studentGroup);
//                }
//                case 23 -> {
//                    GroupService service = new GroupServiceIMPL();
//                    service.getAllGroups().forEach(System.out::println);
//                }
//                case 22 -> {
//                    System.out.println("Введите id студента");
//                    UUID uuid = UUID.fromString(in.next());
//                    StudentsService studentsService = new StudentsServiceIMPL();
//                    studentsService.deleteStudent(uuid);
//                }
//                case 4 -> {
//                    System.out.println("Введите id студента");
//                    UUID studentId = UUID.fromString(in.next());
//                    System.out.println("Введите телефон");
//                    String phone = in.next();
//                    System.out.println("Введите тип телефона (моб/дом)");
//                    String typePhone = in.next();
//                    Phone studentPhone = new Phone(phone, typePhone, studentId);
//                    PhoneService service = new PhoneServiceIMPL();
//                    service.addPhone(studentPhone);
//
//                }
//                case 41 -> {
//                    PhoneService service = new PhoneServiceIMPL();
//                    service.getAllPhones().forEach(System.out::println);
//                }
//                case 5 -> {
//                    System.out.println("Введите id студента");
//                    UUID studentId = UUID.fromString(in.next());
//                    StudentsService studentsService = new StudentsServiceIMPL();
//                    System.out.println(studentsService.getStudentById(studentId));
//                }
//                case 6-> {
//                    System.out.println("Введите id студента");
//                    UUID studentIdForEmail = UUID.fromString(in.next());
//                    System.out.println("Введите email");
//                    String email = in.next();
//                    Email studentEmail = new Email(email, studentIdForEmail);
//                    EmailService service = new EmailServiceIMPL();
//                    service.addEmail(studentEmail);
//                }
//                case 7 -> {
//                    SubjectService service = new SubjectServiceIMPL();
//                    service.getAllSubjects().forEach(System.out::println);
//                }
//                case 71 -> {
//                    System.out.println("Введите id студента");
//                    UUID studentIdForSubject = UUID.fromString(in.next());
//                    System.out.println("Введите id предмета");
//                    UUID subjectId = UUID.fromString(in.next());
//                    StudentSubjectService service = new StudentSubjectServiceIMPL();
//                    StudentSubject studentSubject =
//                            new StudentSubject(studentIdForSubject, subjectId);
//                    service.addSubjectStudent(studentSubject);
//
//                }
//                    case 8 -> {
//                    System.out.println("Введите название предмета");
//                    String subjectName = in.next();
//                    Subject subject = new Subject(subjectName);
//                    SubjectService service = new SubjectServiceIMPL();
//                    service.addSubject(subject);
//                }
//                case 81 -> {
//                    System.out.println("Введите id студента");
//                    UUID studentIdForAssessment = UUID.fromString(in.next());
//                    System.out.println("Введите id предмета");
//                    UUID subjectId = UUID.fromString(in.next());
//                    System.out.println("Введите id темы");
//                    UUID topicId = UUID.fromString(in.next());
//                    System.out.println("Введите оценку");
//                    int mark = in.nextInt();
//                    StudentSubjectService service = new StudentSubjectServiceIMPL();
//                    StudentSubject studentSubject = service.getStudentSubjectsByStudentAndSubjectId(studentIdForAssessment, subjectId);
//                    Assessment assessment = new Assessment(studentSubject.getId(), mark, topicId);
//                    AssessmentService assessmentService = new AssessmentServiceIMPL();
//                    assessmentService.addAssessment(assessment);
//                }
//                case 82 -> {
//                    System.out.println("Введите id студента");
//                    UUID studentIdForAssessment = UUID.fromString(in.next());
//                    System.out.println("Введите id предмета");
//                    UUID subjectId = UUID.fromString(in.next());
//                    StudentSubjectService service = new StudentSubjectServiceIMPL();
//                    StudentSubject studentSubject = service.getStudentSubjectsByStudentAndSubjectId(studentIdForAssessment,subjectId);
//                    AssessmentService assessmentService = new AssessmentServiceIMPL();
//                    assessmentService.getAssessmentsOfSubjectStudent(studentSubject.getId())
//                            .stream()
//                            .map(Assessment::getMark)
//                            .forEach(System.out::println);
//                }
//                case 9 -> {
//                    System.out.println("Введите id предмета");
//                    UUID subjectId = UUID.fromString(in.next());
//                    System.out.println("Введите название темы");
//                    String topicName = in.next();
//                    Topic topic = new Topic(topicName, subjectId);
//                    TopicsOfSubjectService service = new TopicsOfSubjectIMPL();
//                    service.addTopic(topic);
//                    SubjectService subjectService = new SubjectServiceIMPL();
//                    Subject subject = subjectService.getSubjectById(subjectId);
//                    subject.setTopics(topic);
//                }
//                case 91 -> {
//                    System.out.println("Введите id предмета");
//                    UUID subjectId = UUID.fromString(in.next());
//                    SubjectService service = new SubjectServiceIMPL();
//                    Subject subject = service.getSubjectById(subjectId);
//                    System.out.println(subject);
//                }
//                case 92 -> {
//                    System.out.println("Введите id предмета");
//                    UUID subjectId = UUID.fromString(in.next());
//                    TopicsOfSubjectService service = new TopicsOfSubjectIMPL();
//                    service.getTopicsBySubjectSubjectId(subjectId).forEach(System.out::println);
//                }
//                case 10 ->{
//                    System.out.println("Введите id студента");
//                    UUID studentId = UUID.fromString(in.next());
//                    System.out.println("Введите id факультета");
//                    UUID facultyId = UUID.fromString(in.next());
//                    System.out.println("Введите id группы");
//                    UUID groupId = UUID.fromString(in.next());
//                    System.out.println("Введите id специализации");
//                    UUID specializationId = UUID.fromString(in.next());
//                    ComplexId complexId = new ComplexId(studentId, facultyId, groupId, specializationId);
//                    ComplexStudentService service = new ComplexStudentServiceImpl();
//                    service.addComplexId(complexId);
//                }
//                case 101 -> {
//                    ComplexStudentService service = new ComplexStudentServiceImpl();
//                    service.getAllComplexStudents().forEach(System.out::println);
//                }
//                case 111 -> {
//                    FacultyService service = new FacultyServiceIMPL();
//                    service.getAllFaculties().forEach(System.out::println);
//                }
//                case 113 -> {
//                    System.out.println("Введите название специализации");
//                    String specializationName = in.next();
//                    System.out.println("Введите название факультета");
//                    UUID facultyId = UUID.fromString(in.next());
//                    Specialization specialization = new Specialization(specializationName, facultyId);
//                    SpecializationService service = new SpecializationServiceIMPL();
//                    service.addSpecialization(specialization);
//                }
//                case 114 -> {
//                    System.out.println("Введите id студента");
//                    UUID studentId = UUID.fromString(in.next());
//                    System.out.println("Введите id предмета");
//                    UUID subjectId = UUID.fromString(in.next());
//                    System.out.println("Введите id оценки");
//                    UUID assessmentId = UUID.fromString(in.next());
//                    StudentSubjectService studentSubjectService = new StudentSubjectServiceIMPL();
//                    StudentSubject studentSubject = studentSubjectService.getStudentSubjectsByStudentAndSubjectId(studentId,subjectId);
//                    StudentsService studentsService = new StudentsServiceIMPL();
//                    Student student = studentsService.getStudentById(studentSubject.getStudentId());
//                    SubjectService subjectService = new SubjectServiceIMPL();
//                    Subject subject = subjectService.getSubjectById(subjectId);
//                    AssessmentService assessmentService = new AssessmentServiceIMPL();
//                    Assessment assessment = assessmentService.getAssessmentById(assessmentId);
//                    TimeTableService timeTableService = new TimeTableServiceImpl();
//                    TimeTable timeTable = timeTableService.getTimeTableBySubjectId(subjectId);
//                    TeacherService teacherService = new TeacherServiceImpl();
//                    Teacher teacher = teacherService.getTeacherById(timeTable.getTeacherId());
//                    DataStudent dataStudent = new DataStudent(student, subject.getNameSubject(), assessment.getMark(), "" + teacher.getFirstName() + " " + teacher.getThirdName());
//                    System.out.println(dataStudent);
//                }
//                case 115 -> {
//                    System.out.println("Введите id преподавателя");
//                    UUID teacherId = UUID.fromString(in.next());
//                    TeacherService teacherService = new TeacherServiceImpl();
//                    Teacher teacher = teacherService.getTeacherById(teacherId);
//                    System.out.println("Введите введите кол-во часов");
//                    int hours = in.nextInt();
////                    TimeTable timeTable = new TimeTable(teacherId, hours);
//                    TimeTableService service = new TimeTableServiceImpl();
////                    service.addTimeTable(timeTable);
//                }
//                case 200 -> {
//                    System.out.println("Введите имя учителя");
//                    String teacherFirstName = in.next();
//                    System.out.println("Введите фамилию учителя");
//                    String teacherSecondName = in.next();
//                    System.out.println("Введите id предмета");
//                    UUID subjectId = UUID.fromString(in.next());
//                    Teacher teacher = new Teacher(teacherFirstName, teacherSecondName);
//                    TeacherService service = new TeacherServiceImpl();
//                    service.addTeacher(teacher);
//                }
//                case 201 -> {
//                    System.out.println("Введите id преподавателя");
//                    UUID teacherId = UUID.fromString(in.next());
//                    TeacherService service = new TeacherServiceImpl();
//                    Teacher teacher = service.getTeacherById(teacherId);
//                    System.out.println(teacher);
//                }
////                case 300 -> {
////                    System.out.println("Введите id преподавателя");
////                    UUID teacherId = UUID.fromString(in.next());
////                    TeacherService service = new TeacherServiceImpl();
////                    Teacher teacher = service.getTeacherById(teacherId);
////                    System.out.println("Введите id предмета");
////                    UUID subjectId = UUID.fromString(in.next());
////
////                    TimeTable timeTable = new TimeTable(teacherId, subjectId, );
////                }
//                case 0 -> MenuProgram.menuProgram();
//                default -> System.out.println("Введите правильный номер");
//            }
//        } while (menu != 90);
//    }
     }
}

// TODO: 04.02.2023 нужно ли делать выполнение метода deletePhone и если делать то через phoneId или через studentId?
