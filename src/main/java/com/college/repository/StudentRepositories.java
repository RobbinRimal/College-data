package com.college.repository;

import com.college.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepositories extends CrudRepository <Student,Long>{
}
