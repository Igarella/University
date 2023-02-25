package org.example.company.controller;

import lombok.AllArgsConstructor;
import org.example.company.DTO.Student;
import org.example.company.services.StudentsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
//    @Autowired
    private StudentsService studentsService;

//    public StudentController(StudentsService studentsService) {
//        this.studentsService = studentsService;
//    }

    @GetMapping("/")
    public List<Student> getAllStudents() {
//        model.addAttribute("students", studentsService.getAllStudents());
        try {
            System.out.println("going to show all students");
            return studentsService.getAllStudents();

        } catch (Exception e) {
            return null;
        }
//        return "students/all";
    }

//    @GetMapping("/{id}")
//    public String getStudentById() {
//    }
}
