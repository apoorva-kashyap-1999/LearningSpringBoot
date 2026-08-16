package com.springBoot.LearningRestApi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springBoot.LearningRestApi.config.ConfigMapper;
import com.springBoot.LearningRestApi.dto.AddStudentRequestDto;
import com.springBoot.LearningRestApi.dto.StudentDto;
import com.springBoot.LearningRestApi.entity.Student;
import com.springBoot.LearningRestApi.repository.StudentRepository;
import com.springBoot.LearningRestApi.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //final is mandatory for this annotation to work. It will create a constructor with all final fields as parameters.
public class StudentServiceImpl implements StudentService {
    
    private final StudentRepository studentRepository;
    private final ConfigMapper configMapper;

    //student->studendto everytime is cumbersome lets use a model-mapper
    @Override
    public List<StudentDto> getAllStudents() {
        // Implementation for fetching all students
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream()
            .map(s -> new StudentDto(s.getName(), s.getId(), s.getEmail()))
                .toList();
        return studentDtos;
    }
 
    @Override
    public StudentDto getStudentById(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
        StudentDto studentDto = configMapper.modelMapper().map(student, StudentDto.class); 
        return studentDto;       
        // return studentRepository.findById(id)
        //         .map(s -> new StudentDto(s.getName(), s.getId(), s.getEmail()))
        //         .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto newstudentDto) {
        Student newstudent = configMapper.modelMapper().map(newstudentDto, Student.class);
        //saves in db
        Student savedStudent = studentRepository.save(newstudent);
        StudentDto studentDto = configMapper.modelMapper().map(savedStudent, StudentDto.class);
        return studentDto;
    }

    @Override
    public void deleteStudentById(Long id){
        if(!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateNewStudent(StudentDto studentDto) {
        Student existingStudent = studentRepository.findById(studentDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + studentDto.getId()));
        
        existingStudent.setName(studentDto.getName());
        existingStudent.setEmail(studentDto.getEmail());
        
        Student updatedStudent = studentRepository.save(existingStudent);
        StudentDto updatedStudentDto = configMapper.modelMapper().map(updatedStudent, StudentDto.class);
        return updatedStudentDto;
    }

    @Override
    public StudentDto updateStudentPartially(Long id, StudentDto studentDto) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
        
        if (studentDto.getName() != null) {
            existingStudent.setName(studentDto.getName());
        }
        if (studentDto.getEmail() != null) {
            existingStudent.setEmail(studentDto.getEmail());
        }
        
        Student updatedStudent = studentRepository.save(existingStudent);
        StudentDto updatedStudentDto = configMapper.modelMapper().map(updatedStudent, StudentDto.class);
        return updatedStudentDto;
    }
}
