package com.college.converter;

import com.college.command.StudentCommand;
import com.college.model.Student;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class StudentCommandToStudent implements Converter<StudentCommand, Student> {

    @Nullable
    @Synchronized
    @Override
    public Student convert(StudentCommand source) {
      if(source==null){  return null;}

        final Student student=new Student();
      student.setCourseSet(source.getCourseSet());
      student.setYear(source.getYear());
      student.setCourseLength(source.getCourseLength());
      return student;
    }
}
