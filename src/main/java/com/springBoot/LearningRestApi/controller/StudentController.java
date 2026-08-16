package com.springBoot.LearningRestApi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.LearningRestApi.dto.AddStudentRequestDto;
import com.springBoot.LearningRestApi.dto.StudentDto;
import com.springBoot.LearningRestApi.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students") //base url for all the endpoints in this controller
public class StudentController {
    
    private final StudentService studentService;

    
    // @GetMapping("/students")
    // public List<StudentDto> getStudent(){
    //     return studentService.getAllStudents();
    // }

    
    // @GetMapping("/students")
    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    //id is path variable and dynamic
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

    // @PostMapping("/students")
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody AddStudentRequestDto newstudentDto){
        // Implementation for creating a new student
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(newstudentDto));
    }
}
