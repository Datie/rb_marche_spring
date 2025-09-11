package com.fdkservice.rbmarche.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.fdkservice.rbmarche.entity.Plan;
import com.fdkservice.rbmarche.entity.User;

@Repository
public interface UserRepository extends ListCrudRepository<Plan, Long> {
	List<User> findUsersByName(String name);
}
