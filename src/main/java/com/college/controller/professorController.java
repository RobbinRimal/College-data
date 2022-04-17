package com.college.controller;

import com.college.model.Professor;
import com.college.repository.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@RequestMapping({"/professor","/",""})
@Controller
@Slf4j
public class professorController {
    ProfessorRepository professorRepository;

    public professorController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @GetMapping("/form")
    public String professorDataForm(){
        Logger.getLogger("i working");
    return "professorForm";
}
@PostMapping("/form")
    public String save(Professor professor){
    professorRepository.save(professor);

    return "redirect:/form";
}

}
