package com.microservices.student.controller;


import com.microservices.student.entities.Student;
import com.microservices.student.services.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(Student student) {
        studentService.save(student);
    }


    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @GetMapping("/search-ny-course/{idCourse}")
    public ResponseEntity<?> searchByCourse(@PathVariable Long idCourse) {
        return ResponseEntity.ok(studentService.findallbyIdCourse(idCourse));
    }
}
