package com.fdkservice.rbmarche.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.fdkservice.rbmarche.entity.Plan;

@Repository
public interface PlanRepository extends ListCrudRepository<Plan, Long> {

}
