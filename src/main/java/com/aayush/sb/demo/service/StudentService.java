package com.aayush.sb.demo.service;

import com.aayush.sb.demo.dto.StudentDTO;

import java.util.List;

public interface StudentService {

     StudentDTO getStudent(long id);

     List<StudentDTO> getStudents();

     StudentDTO createStudent(StudentDTO studentDTO);

     StudentDTO editStudent(long id, StudentDTO studentDTO);

     void deleteStudent(long id);
}
