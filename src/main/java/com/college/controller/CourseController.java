package com.college.controller;

import com.college.command.CourseCommand;
import com.college.command.SubjectCommand;
import com.college.service.CourseService;
import com.college.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@Controller
@Slf4j
public class CourseController {
CourseService courseService;
SubjectService subjectService;


    public CourseController(CourseService courseService, SubjectService subjectService) {
        this.courseService = courseService;
        this.subjectService = subjectService;
    }

    @GetMapping("Student/{id}/Course/new")
    String getNewCourse(@PathVariable String id, Model model){
        CourseCommand courseCommand=new CourseCommand();
        courseCommand.setID(Long.getLong(id));
        model.addAttribute("course" ,courseCommand);
        //todo
        courseCommand.setSubjectSet((Set<SubjectCommand>) new CourseCommand());
        model.addAttribute("Subjects",subjectService.findCommandById(Long.parseLong(id)));
        return "student/subject/subjectform";
    }

}
