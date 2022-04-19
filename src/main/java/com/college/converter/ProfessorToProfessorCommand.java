package com.college.converter;

import com.college.command.ProfessorCommand;
import com.college.model.BaseEntity;
import com.college.model.Professor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProfessorToProfessorCommand implements Converter<Professor, ProfessorCommand> {
    public ProfessorToProfessorCommand() {
    }

    @Override
    @Nullable
    @Synchronized
    public ProfessorCommand convert(Professor source) {





        if (source==null){return null;}
        final  ProfessorCommand professorCommand= new ProfessorCommand();

        professorCommand.setID(source.getID());
        professorCommand.setUniversity(source.getUniversity());
        professorCommand.setFaculty(source.getFaculty());
        professorCommand.setExperience(source.getExperience());
        professorCommand.setSubjects(source.getSubjects());
        professorCommand.setName(source.getName());
        professorCommand.setLastName(source.getLastName());
        professorCommand.setFatherName(source.getFatherName());
        professorCommand.setEmail(source.getEmail());
        professorCommand.setDob(source.getDob());
        professorCommand.setAddress(source.getAddress());
        professorCommand.setImage(source.getImage());


        return professorCommand;
    }




}
