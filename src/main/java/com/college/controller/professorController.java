package com.college.controller;

import com.college.command.ProfessorCommand;
import com.college.service.ProfessorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
//todo it's working dont mesh it

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
        public String Save(@Valid @ModelAttribute("professor") ProfessorCommand command,
                           BindingResult bindingResult){
        if (bindingResult
                .hasErrors()){
                    bindingResult
                    .getAllErrors()
                    .forEach(objectError -> {
                        log.debug(objectError.toString());
                                                             });
                        return "professor/professorform";
        }
        ProfessorCommand saveprofessor=professorService.saveProfessorCommand(command);


                return "redirect:/professor/"+saveprofessor.getID()+"/show";
            }


            @GetMapping("/professor/{id}/show")
            public String showProfessor(@PathVariable String id,Model model){
            model.addAttribute("professor" ,professorService.findCommandById(Long.parseLong(id)));
            return "professor/show";

            }

            @GetMapping("/professor/showall")
            public String showProfessors(Model model){
            model.addAttribute("professors",professorService.getProfessors());
            return "professor/showall";

            }
}
