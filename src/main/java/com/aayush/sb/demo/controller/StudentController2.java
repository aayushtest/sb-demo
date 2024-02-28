package com.aayush.sb.demo.controller;
import com.aayush.sb.demo.dto.StudentDTO;
import com.aayush.sb.demo.exceptions.InvalidIdException;
import com.aayush.sb.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // get all students (GET)
    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.ACCEPTED);
    }

    // get a single student with an ID (GET)
    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable long id){
       return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.ACCEPTED);
    }

    // create a new student (POST)
    @PostMapping("/student")
    public  ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO newStudent = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(newStudent,HttpStatus.ACCEPTED);
    }

    // Edit Student (PUT)
    @PutMapping("/student/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable long id, @RequestBody StudentDTO studentDTO){
        //StudentDTO newStudent = studentService.getStudent(id);
        // check if student with id is non negative
        if (id<0){
            // if id is negative then throw an error
            throw new InvalidIdException("invalid student ID");
        }
        StudentDTO student = studentService.editStudent(id, studentDTO);
        return new ResponseEntity<>(student,HttpStatus.ACCEPTED);
    }



    // Delete Student (DELETE)
    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
        // check if id is positive
        if (id<0){
            // if id is negative then throw an error
            throw new InvalidIdException("invalid student ID");
        }
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student with id " + id +" deleted Successfully!",HttpStatus.OK);
    }
}
