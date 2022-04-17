package com.college.converter;

import com.college.command.StudentCommand;
import com.college.model.Student;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class StudentToStudentCommand implements Converter<Student, StudentCommand> {
    @Override
    @Synchronized
    @Nullable
    public StudentCommand convert(Student source) {
        if (source==null){return null;}
        final   StudentCommand studentCommand=new StudentCommand();
        studentCommand.setCourseSet(source.getCourseSet());
        studentCommand.setYear(source.getYear());
        studentCommand.setCourseLength(source.getCourseLength());
        return  studentCommand;
    }
}
