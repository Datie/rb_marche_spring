package com.fdkservice.rbmarche.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.fdkservice.rbmarche.entity.Line;
import com.fdkservice.rbmarche.entity.Plan;

@Repository
public interface LineRepository extends ListCrudRepository<Line, Long> {
	
	List<Line> findLinesByPlan(Plan plan);

}
