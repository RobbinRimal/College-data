package com.college.converter;

import com.college.command.SubjectCommand;
import com.college.model.Subject;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SubjectCommandToSubject implements Converter<SubjectCommand,Subject> {

@Synchronized
@Nullable
    @Override
    public Subject convert(SubjectCommand source) {
        if (source==null){return null;}
        Subject subject= new Subject();
        subject.setSubjectName("x");
        return subject;
    }
}
