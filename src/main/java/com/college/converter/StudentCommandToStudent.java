package com.college.converter;

import com.college.command.CourseCommand;
import com.college.command.StudentCommand;
import com.college.command.SubjectCommand;
import com.college.model.Student;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class StudentCommandToStudent implements Converter<StudentCommand, Student> {
    CourseCommandToCourse courseCommandToCourse;
    SubjectCommandToSubject subjectCommandToSubject;

    public StudentCommandToStudent(CourseCommandToCourse courseCommandToCourse,
                                   SubjectCommandToSubject subjectCommandToSubject) {
        this.courseCommandToCourse = courseCommandToCourse;
        this.subjectCommandToSubject = subjectCommandToSubject;
    }

    @Nullable
    @Synchronized
    @Override
    public Student convert(StudentCommand source) {
      if(source==null){  return null;}



        final Student student=new Student();
      student.setID(source.getID());
      student.setName(source.getName());
      student.setLastName(source.getLastName());
      student.setFatherName(source.getFatherName());
      student.setEmail(source.getEmail());
      student.setDob(source.getDob());
      student.setAddress(source.getAddress());
      student.setImage(source.getImage());
      student.setYear(source.getYear());
      student.setCourseLength(source.getCourseLength());

        if(source.getCourseSet()!=null&& source.getCourseSet().size()>0){
            CourseCommand courseCommand=new CourseCommand();
            SubjectCommand subjectCommand= new SubjectCommand();
            source.getCourseSet().forEach(course -> student.getCourseSet()
                    .add(courseCommandToCourse.convert(course)));


        }
        return student;
    }
}
