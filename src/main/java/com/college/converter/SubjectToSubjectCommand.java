package com.college.converter;

import com.college.command.SubjectCommand;
import com.college.model.Subject;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class SubjectToSubjectCommand implements Converter<Subject, SubjectCommand> {
    @Nullable
    @Synchronized
    @Override
    public SubjectCommand convert(Subject source) {
        if (source==null){return null;}
        SubjectCommand subjectCommand=new SubjectCommand();
        subjectCommand.setSubjectName(source.getSubjectName());
        return subjectCommand;
    }
}
