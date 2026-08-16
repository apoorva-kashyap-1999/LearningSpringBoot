package com.springBoot.LearningRestApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//data will create getter and setter for all the fields in the class
//allargsconstructor will create a constructor with all the fields in the class
@Data
@AllArgsConstructor
@NoArgsConstructor //required for modelmapper to work
public class AddStudentRequestDto {
     private  String name;
    //  private Long id; db will create this id automatically so we don't need to send it in the request body
     private String email;
    }
