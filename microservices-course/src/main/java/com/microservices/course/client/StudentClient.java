package com.microservices.course.client;


import com.microservices.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "localhost:8090/api/student/")
public interface StudentClient {

    @GetMapping("/search-ny-course/{idCourse}")
    List<StudentDTO> findAllStudentByCourse(@PathVariable Long idCourse);
}
