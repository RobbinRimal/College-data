package com.college.command;

import com.college.model.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
public class StudentCommand  extends Personcommand{
    private Set<Course> courseSet=new HashSet<>();
    private int year;
    private  int courseLength;
}
