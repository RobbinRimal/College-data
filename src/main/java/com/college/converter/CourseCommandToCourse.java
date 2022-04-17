package com.college.converter;

import com.college.command.CourseCommand;
import com.college.model.Course;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
@Component
public class CourseCommandToCourse implements Converter<CourseCommand, Course>{

    @Synchronized
    @Nullable
    @Override
    public Course convert(CourseCommand source) {
        if (source == null) {
            return null;


        }
       final Course course= new Course();
        course.setCourse(source.getCourse());
        course.setSubjectSet(source.getSubjectSet());
        return course;

    }


}


