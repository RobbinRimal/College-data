package com.college.service;

import com.college.command.StudentCommand;
import com.college.model.Student;

public interface StudentService {
    StudentCommand SaveStudentCommand(StudentCommand  command);
    StudentCommand findCommandById(Long L);
    Student findById(Long L);
}
