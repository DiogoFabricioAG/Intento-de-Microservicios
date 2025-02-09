package com.microservices.course.services;

import com.microservices.course.client.StudentClient;
import com.microservices.course.dto.StudentDTO;
import com.microservices.course.entities.Course;
import com.microservices.course.http.response.StudentByCourseResponse;
import com.microservices.course.persistence.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentByIdCourse(Long idCourse) {


        Course course = courseRepository.findById(idCourse).orElseThrow();

        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(course.getId());

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
