package com.college.command;

import com.college.model.Subject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CourseCommand {
    private String course;
    private Set<Subject> subjectSet=new HashSet<>();

    
}
