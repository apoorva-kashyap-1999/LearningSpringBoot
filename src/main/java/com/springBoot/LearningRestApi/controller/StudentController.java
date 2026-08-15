package com.springBoot.LearningRestApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.LearningRestApi.dto.StudentDto;

@RestController
public class StudentController {
    
    @GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto("Apoorva ", 1L, "ap.kp@example.com");
    }
     
}
