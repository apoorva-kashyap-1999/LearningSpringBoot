package com.springBoot.LearningRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.LearningRestApi.entity.Student;

//it is not necessary to add @Repository annotation because JpaRepository already has @Repository annotation. But it is a good practice to add it.
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
