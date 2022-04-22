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
public class CourseCommand extends BaseEntityCommand{
    private String course;
    private Set<SubjectCommand> subjectSet=new HashSet<>();

    
}
