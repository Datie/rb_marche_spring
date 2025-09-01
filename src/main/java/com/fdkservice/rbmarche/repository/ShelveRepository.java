package com.fdkservice.rbmarche.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.fdkservice.rbmarche.entity.Line;
import com.fdkservice.rbmarche.entity.Shelve;

@Repository
public interface ShelveRepository extends ListCrudRepository<Shelve, Long> {
	
	List<Shelve> findShelvesByLine(Line line);

}
