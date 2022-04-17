package com.college.converter;

import com.college.command.ProfessorCommand;
import com.college.model.Professor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class ProfessorToProfessorCommand implements Converter<Professor, ProfessorCommand> {
    @Override
    @Nullable
    @Synchronized
    public ProfessorCommand convert(Professor source) {
        if (source==null){return null;}
        final  ProfessorCommand professorCommand= new ProfessorCommand();
        professorCommand.setUniversity(source.getUniversity());
        professorCommand.setFaculty(source.getFaculty());
        professorCommand.setExperience(source.getExperience());
        professorCommand.setSubjects(source.getSubjects());
        return professorCommand;
    }
}
