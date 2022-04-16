package com.college.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Course")
@Entity
public class Course extends BaseEntity {


    private String course;
    @ManyToMany
    private Set<Subject> subjectSet=new HashSet<>();
}
