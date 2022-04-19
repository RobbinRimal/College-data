package com.college.service;

import com.college.command.ProfessorCommand;
import com.college.converter.ProfessorCommandToProfessor;
import com.college.converter.ProfessorToProfessorCommand;
import com.college.model.Professor;
import com.college.repository.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public ProfessorCommand saveProfessorCommand(ProfessorCommand command) {
        Professor detachedProfessor = professorCommandToProfessor.convert(command);
        Professor SavedProfessor=professorRepository.save(detachedProfessor);
        log.debug("Saved professor "+SavedProfessor.getID());
        return professorToProfessorCommand.convert(SavedProfessor);

    }

    @Override
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
