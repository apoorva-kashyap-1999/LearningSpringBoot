package com.springBoot.LearningRestApi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

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
    public ResponseEntity<StudentDto> createStudent(@RequestBody @Valid AddStudentRequestDto newstudentDto){
        // Implementation for creating a new student
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(newstudentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
    
    //complete change
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto){
        // Implementation for updating a student
        StudentDto updatedStudent = studentService.updateNewStudent(studentDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
    }

    //partial change
    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> partiallyUpdateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto){
        // Implementation for partially updating a student
        StudentDto updatedStudent = studentService.updateStudentPartially(id,studentDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
    }

}
