package com.college.repository;

import com.college.model.BaseEntity;
import org.springframework.data.repository.CrudRepository;

public interface BaseEntityRepository extends CrudRepository<BaseEntity,Long> {
}
