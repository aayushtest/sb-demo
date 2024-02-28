package com.aayush.sb.demo.service.impl;

import com.aayush.sb.demo.dao.StudentDao;
import com.aayush.sb.demo.dto.StudentDTO;
import com.aayush.sb.demo.model.Student;
import com.aayush.sb.demo.service.StudentService;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Override
    public StudentDTO getStudent(long id) {
        Optional<Student> optionalStudent = studentDao.findById(id);
        StudentDTO studentDTO = null;
        if (optionalStudent.isEmpty()) {
            return null;
        } else {
            studentDTO = new StudentDTO();
            studentDTO.setId(optionalStudent.get().getId());
            studentDTO.setName(optionalStudent.get().getName());
            studentDTO.setEmail(optionalStudent.get().getEmail());
            return studentDTO;

        }
    }

    @Override
    public List<StudentDTO> getStudents() {
        List<Student> students = studentDao.findAll();
        List<StudentDTO> respStudents = new ArrayList<>();

        for (Student student: students){
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setName(student.getName());
            studentDTO.setEmail(student.getEmail());
            respStudents.add(studentDTO);
            // System.out.println(student);
        }

        return respStudents;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        // to save student we need to convert DTO to entity class i.e. studentDTO to student class
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        Student dbStudent = studentDao.save(student); // this will save the student class
        // we need to convert entity into DAo class meaning student class to studentdto class
        StudentDTO respStudentDTO = new StudentDTO();
        respStudentDTO.setId(dbStudent.getId());
        respStudentDTO.setName(dbStudent.getName());
        respStudentDTO.setEmail(dbStudent.getEmail());
        return respStudentDTO;
    }

    public StudentDTO editStudent(long id, StudentDTO studentDTO) {
        // first get the student with their ID
        Student student = studentDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user with id " + id + "not found"));
        student.setEmail(studentDTO.getEmail());
        student.setName(studentDTO.getName());
        studentDTO.setId(id);
        return studentDTO;

    }

    @Override
    public void deleteStudent(long id) {
         studentDao.deleteById(id);
    }
}
