package com.college.converter;

import com.college.command.CourseCommand;
import com.college.model.Course;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CourseToCourseCommand implements Converter<Course, CourseCommand> {
    @Synchronized
    @Nullable
    @Override
    public CourseCommand convert(Course source) {
        if (source==null){return null;}
        final CourseCommand courseCommand=new CourseCommand();
        courseCommand.setCourse(source.getCourse());
        courseCommand.setSubjectSet(source.getSubjectSet());
        return  courseCommand;

    }
}
