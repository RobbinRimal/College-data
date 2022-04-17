package com.college.converter;

import com.college.command.ProfessorCommand;
import com.college.model.Professor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.lang.Nullable;

import javax.persistence.Convert;

public class ProfessorCommandToProfessor implements Converter<ProfessorCommand,Professor> {

    @Synchronized
    @Nullable
    @Override
    public Professor convert(ProfessorCommand source) {
        if (source==null) {
            return null;
        }
        final  Professor professor =new Professor();
        professor.setUniversity(source.getUniversity());
        professor.setFaculty(source.getFaculty());
        professor.setExperience(source.getExperience());
        professor.setSubjects(source.getSubjects());
        return professor;
    }
}
