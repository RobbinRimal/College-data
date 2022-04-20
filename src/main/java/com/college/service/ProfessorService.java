package com.college.service;

import com.college.command.ProfessorCommand;
import com.college.model.Professor;

import java.util.Set;

public interface ProfessorService {

   public Set<Professor> getProfessors();
   ProfessorCommand saveProfessorCommand(ProfessorCommand command);
   ProfessorCommand findCommandById(Long L);
   //Not having this was crating all the stupid problem asking for the mapping of optional class:
   //todo implement findById with long as argument and Professor  return type:
   Professor findById(Long L);

}
