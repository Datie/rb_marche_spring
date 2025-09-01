package com.fdkservice.rbmarche.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fdkservice.rbmarche.entity.Board;
import com.fdkservice.rbmarche.entity.Line;
import com.fdkservice.rbmarche.entity.Plan;
import com.fdkservice.rbmarche.entity.Shelve;
import com.fdkservice.rbmarche.entity.ShelveType;
import com.fdkservice.rbmarche.repository.BoardRepository;
import com.fdkservice.rbmarche.repository.LineRepository;
import com.fdkservice.rbmarche.repository.PlanRepository;
import com.fdkservice.rbmarche.repository.ShelveRepository;
import com.fdkservice.rbmarche.repository.ShelveTypeRepository;

@Service
@Transactional
public class SetService {

	@Autowired
	ShelveTypeRepository shelveTypeRepository;
	
	@Autowired
	LineRepository lineRepository;
	
	@Autowired
	ShelveRepository shelveRepository;
	
	@Autowired
	PlanRepository planRepository; 
	
	@Autowired
	BoardRepository boardRepository; 
	
	public long getCountOfAllLine() {
		return lineRepository.count();
	}
	
	public List<Line> findLinesByPlan(Plan plan) {
		return lineRepository.findLinesByPlan(plan);
	}
	
	public List<Shelve> findShelvesByLine(Line line) {
		return shelveRepository.findShelvesByLine(line);
	}
	
	public List<Board> findBoardsByShelve(Shelve shelve) {
		return boardRepository.findBoardsByShelve(shelve);
	}
	
	public long getCountOfAllShelveType() {
		return shelveTypeRepository.count();
	}	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteAllShelves() {
		shelveRepository.deleteAll();
	}
	
	public List<Shelve> getAllShelves() {
		return shelveRepository.findAll();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Shelve createShelve(Shelve shelve) {
		return shelveRepository.save(shelve);
	}	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteAllPlans() {
		planRepository.deleteAll();
	}
	
	public List<Plan> getAllPlans() {
		return planRepository.findAll();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Plan createPlan(Plan plan) {
		return planRepository.save(plan);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteAllLines() {
		lineRepository.deleteAll();
	}
	
	public List<Line> getAllLines() {
		return lineRepository.findAll();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Line createLine(Line line) {
		return lineRepository.save(line);
	}

	public List<ShelveType> getAllShelveTypes() {
		return shelveTypeRepository.findAll();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteAllShelveType() {
		shelveTypeRepository.deleteAll();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void createShelveType(Iterable<ShelveType> entities) {
		shelveTypeRepository.saveAll(entities);
	}
	
	public Board createBoard(Board board) {
		return boardRepository.save(board);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteAllBoard() {
		boardRepository.deleteAll();
	}
	
	public List<Board> getAllBoards() {
		return boardRepository.findAll();
	}

}
