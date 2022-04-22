package com.college.controller;

import com.college.command.SubjectCommand;
import com.college.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller

public class SubjectController {
    SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/student/{id}/subject/new")
    public String addSubject(@PathVariable String id, Model model){
    SubjectCommand subjectCommand=new SubjectCommand();
    subjectCommand.setID(Long.parseLong(id));
    log.debug("the creating new subject is up");
        model.addAttribute("subject",subjectCommand);
        return "student/subject/subjectform";
}
    @PostMapping("subject")
    public  String saveSubject(@Valid @ModelAttribute("subject") SubjectCommand subjectCommand
    , BindingResult bindingResult){
        if (bindingResult
                .hasErrors()) {
            bindingResult
                    .getAllErrors().forEach(objectError -> { log.debug(objectError.toString()); });
            return "student/subject/subjectform";
        }
        SubjectCommand savedCommand =subjectService.saveSubject(subjectCommand);
        return "redirect:/subject/"+savedCommand.getID()+"show";
    }
    @GetMapping("Subject/{id}/show")
    public  String showSubject(@PathVariable String id,Model model){
        SubjectCommand savedCommand=subjectService.findCommandById(Long.parseLong(id));
        model.addAttribute("subject",savedCommand);

        return "student/subject/show";


        }

}
