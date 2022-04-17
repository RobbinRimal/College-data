package com.college.controller;

import org.springframework.web.bind.annotation.RequestMapping;


public class StudentController {
    @RequestMapping("/Form")
    public  String studentDataForm(){

        return "professorForm";
    }

}
