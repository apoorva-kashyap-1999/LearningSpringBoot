package com.springBoot.LearningRestApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//data will create getter and setter for all the fields in the class
//allargsconstructor will create a constructor with all the fields in the class
@Data
@AllArgsConstructor
public class StudentDto {
     private  String name;
     private Long id;
     private String email;
    }

    // public StudentDto(String name, Long id, String email) {
    //     this.name = name;
    //     this.id = id;
    //     this.email = email;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public Long getId() {
    //     return id;
    // }


    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

