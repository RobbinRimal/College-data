package com.college.service;

import com.college.command.CourseCommand;
import com.college.converter.CourseCommandToCourse;
import com.college.converter.CourseToCourseCommand;
import com.college.model.Course;
import com.college.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Slf4j
@Service
public class CourseServiceImpl implements CourseService {
    CourseCommandToCourse courseCommandToCourse;
    CourseToCourseCommand courseToCourseCommand;
    CourseRepository courseRepository;

    public CourseServiceImpl(CourseCommandToCourse courseCommandToCourse,
                             CourseToCourseCommand courseToCourseCommand,
                             CourseRepository courseRepository) {
        this.courseCommandToCourse = courseCommandToCourse;
        this.courseToCourseCommand = courseToCourseCommand;
        this.courseRepository = courseRepository;
    }

    @Override
    public Set<Course> getCourseSet() {
        Set<Course> courseSet=new HashSet<>();
        courseRepository.findAll().iterator().forEachRemaining(courseSet::add);
        return courseSet;
    }

    @Override
    public CourseCommand findCourseCommandById(Long L) {
        return courseToCourseCommand.convert(findByID(L));
    }

    @Override
    @Transactional
    public Course findByID(Long L) {
        Optional<Course> courseOptional=courseRepository.findById(L);
        if (!courseOptional.isPresent()){
            System.out.println("course with given id"+L+" not found");
            throw new RuntimeException("course not found id "+L+".");
        }
    return courseOptional.get();

    }

    @Override
    public CourseCommand save(CourseCommand courseCommand) {
        Course dechedCourse =courseCommandToCourse.convert(courseCommand);
        Course savedCourse=courseRepository.save(dechedCourse);
        log.debug("course saved sucessefully with course  id "+savedCourse.getID());

        return courseToCourseCommand.convert(savedCourse);
    }
}
