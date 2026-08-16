package com.springBoot.LearningRestApi.service;

import java.util.List;

import com.springBoot.LearningRestApi.dto.StudentDto;

public interface StudentService {
    
    List<StudentDto> getAllStudents();
}
