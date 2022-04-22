package com.college.service;

import com.college.command.CourseCommand;
import com.college.model.Course;

import java.util.Optional;
import java.util.Set;

public interface CourseService {
    Set<Course> getCourseSet();
    CourseCommand findCourseCommandById(Long L);
    Course findByID(Long L);
    CourseCommand save(CourseCommand courseCommand);
}
