package com.springBoot.LearningRestApi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springBoot.LearningRestApi.dto.StudentDto;
import com.springBoot.LearningRestApi.entity.Student;
import com.springBoot.LearningRestApi.repository.StudentRepository;
import com.springBoot.LearningRestApi.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    
    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        // Implementation for fetching all students
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream()
            .map(s -> new StudentDto(s.getName(), s.getId(), s.getEmail()))
                .toList();
        return studentDtos;
    }
}
