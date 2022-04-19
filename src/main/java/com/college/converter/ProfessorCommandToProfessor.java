package com.college.converter;

import com.college.command.ProfessorCommand;
import com.college.model.Professor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.Convert;
@Component

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
        professor.setName(source.getName());
        professor.setLastName(source.getLastName());
        professor.setFatherName(source.getFatherName());
        professor.setEmail(source.getEmail());
        professor.setDob(source.getDob());
        professor.setAddress(source.getAddress());
        professor.setImage(source.getImage());
        return professor;
    }
}
