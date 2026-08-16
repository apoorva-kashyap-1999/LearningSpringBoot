package com.springBoot.LearningRestApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.LearningRestApi.dto.StudentDto;
import com.springBoot.LearningRestApi.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudentController {
    
    private final StudentService studentService;

    
    @GetMapping("/students")
    public List<StudentDto> getStudent(){
        return studentService.getAllStudents();
    }

    //id is path variable and dynamic
    @GetMapping("/student/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
}
