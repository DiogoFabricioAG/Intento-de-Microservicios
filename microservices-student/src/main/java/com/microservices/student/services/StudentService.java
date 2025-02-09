package com.microservices.student.services;

import com.microservices.student.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    List<Student> findallbyIdCourse(Long id);

    void save(Student student);

    List<Student> findByIdCourse(Long idCourse);
}
