package com.college.service;

import com.college.command.SubjectCommand;

public interface SubjectService  {
    SubjectCommand saveSubject(SubjectCommand subjectCommand);
    SubjectCommand findCommandById(Long L);

}
