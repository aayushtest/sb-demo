package com.aayush.sb.demo.controller;
import com.aayush.sb.demo.dto.StudentDTO;
import com.aayush.sb.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;  // always autowire interfaces

    @GetMapping("/student")
    public StudentDTO getStudent(@RequestParam Long id) {
        return studentService.getStudent(id);
    }

/* using path variable
    @GetMapping("/student/{id}")
    public StudentDTO getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }
*/

    @GetMapping("/students")
    public List<StudentDTO> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/students")
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO){
        return studentService.createStudent(studentDTO);
    }

}
