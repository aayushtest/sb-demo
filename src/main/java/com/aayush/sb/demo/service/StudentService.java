package com.aayush.sb.demo.service;

import com.aayush.sb.demo.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    public StudentDTO getStudent(long id);

    public List<StudentDTO> getStudents();

    public StudentDTO createStudent(StudentDTO studentDTO);

    public StudentDTO editStudent(long id, StudentDTO studentDTO);

    public void deleteStudent(long id);
}
