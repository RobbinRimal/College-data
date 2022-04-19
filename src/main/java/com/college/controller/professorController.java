package com.college.controller;

import com.college.command.ProfessorCommand;
import com.college.service.ProfessorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@Slf4j

public class professorController {
   ProfessorService professorService;

    public professorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/form")
            public String newprofessor(Model model){
            model.addAttribute("professor",new ProfessorCommand());
            return "professor/professorform";

            }

            @PostMapping("professor")
        public String Save(@Valid @ModelAttribute("professor") ProfessorCommand command, BindingResult bindingResult){
        if (bindingResult
                .hasErrors()){
                    bindingResult
                    .getAllErrors()
                    .forEach(objectError -> {
                        log.debug(objectError.toString());

            });
            return "professor/professorform";
        }
        //todo create saveProfessorCommand interface's method and implement it.
            ProfessorCommand saveprofessor=professorService.saveProfessorCommand(command);
        //todo redrict to show the save professor
                return "redirect:/professor/"+saveprofessor.getID()+"/show";
            }
            @GetMapping("/professor/{id}/show")
            public String showProfessor(@PathVariable String id,Model model){
        //todo Create find by id
        model.addAttribute("professor" ,professorService.findCommandById(Long.parseLong(id)));
            //todo create html file show taking the model attribute professor
            return "prfessor/show";
            }
}
