package com.microservices.course.controller;


import com.microservices.course.entities.Course;
import com.microservices.course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(Course student) {
        courseService.save(student);
    }


    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Course student = courseService.findById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<Course> students = courseService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/search-students/{idCourse}")
    public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long idCourse) {
        return ResponseEntity.ok(courseService.findStudentByIdCourse(idCourse));
    }
}
