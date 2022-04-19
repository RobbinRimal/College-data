package com.college.controller;

import com.college.command.StudentCommand;
import com.college.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.source.internal.hbm.ModelBinder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/student/form")
    public  String studentDataForm(Model model){
        model.addAttribute("student",new StudentCommand());

        return "student/studentform";
    }

    @PostMapping("sudent")
    public String save(@Valid @ModelAttribute("student") StudentCommand command ,
                       BindingResult bindingResult){

        if (bindingResult
                .hasErrors()) {
            bindingResult
                    .getAllErrors().forEach(objectError -> { log.debug(objectError.toString()); });
            return "student/studentform";
        }
        StudentCommand savedCommand=studentService.SaveStudentCommand(command);
        return "redirect:/student/"+savedCommand.getID()+"show";

    }

    @GetMapping("/student/{id}/show")
    public String showStudent(@PathVariable String id, Model model){
        model.addAttribute("student",studentService.findCommandById(Long.parseLong(id)));
        return "student/show";

    }
}
