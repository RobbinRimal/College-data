package com.college.service;

import com.college.command.StudentCommand;
import com.college.model.Student;

import java.util.Set;

public interface StudentService {
    StudentCommand SaveStudentCommand(StudentCommand  command);
     Set<Student> getStudents();
    StudentCommand findCommandById(Long L);
    Student findById(Long L);
}
