package com.springBoot.LearningRestApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.LearningRestApi.dto.StudentDto;
import com.springBoot.LearningRestApi.entity.Student;
import com.springBoot.LearningRestApi.repository.StudentRepository;

@RestController
public class StudentController {
    
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    @GetMapping("/student")
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public StudentDto getStudentById(Long id){
        return new StudentDto("Kashyap ", 3L, "apkk.kp@example.com");
    }
}
