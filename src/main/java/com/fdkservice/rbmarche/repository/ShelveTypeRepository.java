package com.fdkservice.rbmarche.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.fdkservice.rbmarche.entity.ShelveType;

@Repository
public interface ShelveTypeRepository extends ListCrudRepository<ShelveType, Long> {

}
