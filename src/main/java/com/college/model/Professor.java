package com.college.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Professor")
@Entity
public class Professor extends Person{
   private String university;
   private String Faculty;
   private  Integer experience;
   @ManyToMany
   private Set<Subject> subjects = new HashSet<>();
}
