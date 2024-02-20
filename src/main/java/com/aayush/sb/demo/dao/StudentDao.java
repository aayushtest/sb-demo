package com.aayush.sb.demo.dao;

import com.aayush.sb.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {

}
