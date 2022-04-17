package com.college.repository;

import com.college.model.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProfessorRepository extends CrudRepository<Professor,Long> {
}
