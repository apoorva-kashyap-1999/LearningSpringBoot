package com.springBoot.LearningRestApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

//data will create getter and setter for all the fields in the class
//allargsconstructor will create a constructor with all the fields in the class
@Data
@AllArgsConstructor
@NoArgsConstructor //required for modelmapper to work
public class AddStudentRequestDto {
    @NotBlank(message = "Name is mandatory")
    private  String name;
    //  private Long id; db will create this id automatically so we don't need to send it in the request body
    @Email 
    @NotBlank(message = "Email is mandatory")
    private String email;
    }
