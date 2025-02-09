package com.microservices.student.persistence;

import com.microservices.student.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query(value = "SELECT * FROM students s WHERE course_id = :courseId",nativeQuery = true)
    List<Student> findAllStudent(Long courseId);

    // Sino este de aca noma List<Student> findAllByCourseId(Long courseId);

}
