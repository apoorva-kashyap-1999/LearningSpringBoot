package com.springBoot.LearningRestApi.service;

import java.util.List;

import org.jspecify.annotations.Nullable;

import com.springBoot.LearningRestApi.dto.AddStudentRequestDto;
import com.springBoot.LearningRestApi.dto.StudentDto;

public interface StudentService {
    
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(Long id);
    @Nullable
    Object createNewStudent(AddStudentRequestDto newstudentDto);
}
