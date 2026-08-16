package com.springBoot.LearningRestApi.service;

import java.util.List;

import com.springBoot.LearningRestApi.dto.AddStudentRequestDto;
import com.springBoot.LearningRestApi.dto.StudentDto;

public interface StudentService {
    
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(Long id);
    StudentDto createNewStudent(AddStudentRequestDto newstudentDto);
    void deleteStudentById(Long id);
    StudentDto updateNewStudent(StudentDto studentDto);
    StudentDto updateStudentPartially(Long id, StudentDto studentDto);
}
