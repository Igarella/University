package org.example.company.controller;

import org.example.company.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/students")
//@AllArgsConstructor
//@Slf4j
//@Entity
public class StudentController {
//    @Autowired
    private final StudentsService studentsService;

    public StudentController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/")
    public ResponseEntity<String> getAllStudents() {
//        model.addAttribute("students", studentsService.getAllStudents());
        try {
            return ResponseEntity.ok("Serever is working");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something has gone wrong!");
        }
//        return "students/all";
    }

//    @GetMapping("/{id}")
//    public String getStudentById() {
//    }
}
