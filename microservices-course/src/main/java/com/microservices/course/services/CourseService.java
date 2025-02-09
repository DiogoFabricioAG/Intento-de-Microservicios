package com.microservices.course.services;

import com.microservices.course.entities.Course;
import com.microservices.course.http.response.StudentByCourseResponse;
import com.microservices.course.persistence.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<Course> findAll();

    Course findById(Long id);

    void save(Course course);

    StudentByCourseResponse findStudentByIdCourse(Long IdCourse);
}
