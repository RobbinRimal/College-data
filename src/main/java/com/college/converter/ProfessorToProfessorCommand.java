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
    SubjectToSubjectCommand subjectToSubjectCommand;

    public ProfessorToProfessorCommand(SubjectToSubjectCommand subjectToSubjectCommand) {
        this.subjectToSubjectCommand = subjectToSubjectCommand;
    }

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
        professorCommand.setName(source.getName());
        professorCommand.setLastName(source.getLastName());
        professorCommand.setFatherName(source.getFatherName());
        professorCommand.setEmail(source.getEmail());
        professorCommand.setDob(source.getDob());
        professorCommand.setAddress(source.getAddress());
        professorCommand.setImage(source.getImage());

        if(source.getSubjects()!=null&& source.getSubjects().size()>0){
            source.getSubjects().forEach(subject -> professorCommand.getSubjects()
                    .add(subjectToSubjectCommand.convert(subject)));
        }

        return professorCommand;
    }




}
