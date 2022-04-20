package com.college.service;

import com.college.command.ProfessorCommand;
import com.college.converter.ProfessorCommandToProfessor;
import com.college.converter.ProfessorToProfessorCommand;
import com.college.model.Professor;
import com.college.repository.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class ProfessorServiceImpl implements ProfessorService{
    private  final ProfessorRepository professorRepository;
    private  final ProfessorCommandToProfessor professorCommandToProfessor;
    private final ProfessorToProfessorCommand professorToProfessorCommand;

    public ProfessorServiceImpl(ProfessorRepository professorRepository, ProfessorCommandToProfessor
            professorCommandToProfessor, ProfessorToProfessorCommand professorToProfessorCommand) {
        this.professorRepository = professorRepository;
        this.professorCommandToProfessor = professorCommandToProfessor;
        this.professorToProfessorCommand = professorToProfessorCommand;
    }

    @Override
    public Set<Professor> getProfessors() {
        log.debug("trying get all professor data");
        Set<Professor> professorSet=new HashSet<>();
         professorRepository.findAll().iterator().forEachRemaining(professorSet::add);
        System.out.println("sending all required data");
         return professorSet;
    }

    @Override
    public ProfessorCommand saveProfessorCommand(ProfessorCommand command) {
        Professor detachedProfessor = professorCommandToProfessor.convert(command);
        Professor SavedProfessor=professorRepository.save(detachedProfessor);
        log.debug("Saved professor "+SavedProfessor.getID());
        return professorToProfessorCommand.convert(SavedProfessor);

    }

    @Override
    @Transactional
    public ProfessorCommand findCommandById(Long L) {


        //todo complete method
        return professorToProfessorCommand.convert(findById(L));

    }

    @Override
    public Professor findById(Long L) {
       Optional<Professor> professorOptional=professorRepository.findById(L);
       if (!professorOptional.isPresent()){
           throw new RuntimeException("Professor not found");
       }
       return professorOptional.get();
    }
}
