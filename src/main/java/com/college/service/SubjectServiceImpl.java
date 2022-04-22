package com.college.service;

import com.college.command.SubjectCommand;
import com.college.converter.SubjectCommandToSubject;
import com.college.converter.SubjectToSubjectCommand;
import com.college.model.Subject;
import com.college.repository.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class SubjectServiceImpl  implements SubjectService{
    SubjectCommandToSubject subjectCommandToSubject;
    SubjectRepository subjectRepository;
    SubjectToSubjectCommand subjectToSubjectCommand;

    public SubjectServiceImpl(SubjectCommandToSubject subjectCommandToSubject,
                              SubjectRepository subjectRepository,
                              SubjectToSubjectCommand subjectToSubjectCommand) {
        this.subjectCommandToSubject = subjectCommandToSubject;
        this.subjectRepository = subjectRepository;
        this.subjectToSubjectCommand = subjectToSubjectCommand;
    }
        @Override
    public SubjectCommand saveSubject(SubjectCommand subjectCommand){
        Subject detachSubject = subjectCommandToSubject.convert(subjectCommand);
        Subject savedSubject=subjectRepository.save(detachSubject);
        log.debug("Subject saved in database Sucessfully");
        return subjectToSubjectCommand.convert(savedSubject);
    }

    @Override
    public SubjectCommand findCommandById(Long L) {

        return subjectToSubjectCommand.convert(findById(L));
    }

    private Subject findById(Long L) {
        Optional<Subject> subjectOptional=subjectRepository.findById(L);
        if (!subjectOptional.isPresent()){
            System.out.println("here\n is \n\n error");
            log.debug("subject not found");
            throw new RuntimeException("Subject not found!");

        }
        return subjectOptional.get();
    }
}
