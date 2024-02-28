package com.aayush.sb.demo.controller;
import com.aayush.sb.demo.dto.StudentDTO;
import com.aayush.sb.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/")
// this is the new version of rest api for student management
public class StudentController2 {

    // autowire service layer
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable long id){
       return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.ACCEPTED);
    }

}
