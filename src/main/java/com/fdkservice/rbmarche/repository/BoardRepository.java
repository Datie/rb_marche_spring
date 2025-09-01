package com.fdkservice.rbmarche.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.fdkservice.rbmarche.entity.Board;
import com.fdkservice.rbmarche.entity.Shelve;

@Repository
public interface BoardRepository extends ListCrudRepository<Board, Long> {

	List<Board> findBoardsByShelve(Shelve shelve);
	
}
