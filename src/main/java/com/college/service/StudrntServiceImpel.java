package com.college.service;

import com.college.command.StudentCommand;
import com.college.converter.StudentCommandToStudent;
import com.college.converter.StudentToStudentCommand;
import com.college.model.Person;
import com.college.model.Student;
import com.college.repository.StudentRepositories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class StudrntServiceImpel implements  StudentService{
StudentRepositories studentRepositories;
StudentToStudentCommand studentToStudentCommand;
StudentCommandToStudent studentCommandToStudent;

    public StudrntServiceImpel(StudentRepositories studentRepositories,
                               StudentToStudentCommand studentToStudentCommand,
                               StudentCommandToStudent studentCommandToStudent) {
        this.studentRepositories = studentRepositories;
        this.studentToStudentCommand = studentToStudentCommand;
        this.studentCommandToStudent = studentCommandToStudent;
    }

    @Override
    public StudentCommand SaveStudentCommand(StudentCommand command) {
        Student detacherStudrnt=studentCommandToStudent.convert(command);
        Student savedStudet =studentRepositories.save(detacherStudrnt);
        log.debug("Student saved sucessfully"+savedStudet.getID());
        return studentToStudentCommand.convert(savedStudet);

    }

    @Override
    public Set<Student> getStudents() {
        Set<Student> studentSet =new HashSet<>();

                studentRepositories.findAll().iterator().forEachRemaining(studentSet::add);

        return studentSet;
    }

    @Override
    @Transactional
    public StudentCommand findCommandById(Long L) {
        return studentToStudentCommand.convert(findById(L));
    }

    @Override
    public Student findById(Long L) {
        Optional<Student> studentOptional=studentRepositories.findById(L);
        if (!studentOptional.isPresent()){throw  new RuntimeException("Student is not present of the given ID");}

        return studentOptional.get();
    }
}
