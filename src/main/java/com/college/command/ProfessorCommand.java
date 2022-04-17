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
public class ProfessorCommand extends Personcommand {
    private String university;
    private String Faculty;
    private  Integer experience;
    private Set<Subject> subjects = new HashSet<>();
}
