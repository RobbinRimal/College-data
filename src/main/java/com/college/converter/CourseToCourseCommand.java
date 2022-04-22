package com.college.converter;

import com.college.command.CourseCommand;
import com.college.model.Course;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CourseToCourseCommand implements Converter<Course, CourseCommand> {
    SubjectToSubjectCommand subjectToSubjectCommand;

    public CourseToCourseCommand(SubjectToSubjectCommand subjectToSubjectCommand) {
        this.subjectToSubjectCommand = subjectToSubjectCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public CourseCommand convert(Course source) {
        if (source==null){return null;}
        final CourseCommand courseCommand=new CourseCommand();
        courseCommand.setCourse(source.getCourse());

        if(source.getSubjectSet()!=null
                && source.getSubjectSet().size()>0){

            source.getSubjectSet().forEach(subject -> courseCommand
                    .getSubjectSet().add(subjectToSubjectCommand.convert(subject)));
        }


        return  courseCommand;

    }
}
