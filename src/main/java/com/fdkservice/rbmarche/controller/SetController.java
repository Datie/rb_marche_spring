package com.fdkservice.rbmarche.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fdkservice.rbmarche.entity.Board;
import com.fdkservice.rbmarche.entity.Line;
import com.fdkservice.rbmarche.entity.Plan;
import com.fdkservice.rbmarche.entity.Shelve;
import com.fdkservice.rbmarche.entity.ShelveType;
import com.fdkservice.rbmarche.pojo.BoardB;
import com.fdkservice.rbmarche.pojo.LineB;
import com.fdkservice.rbmarche.pojo.PlanB;
import com.fdkservice.rbmarche.pojo.ShelveB;
import com.fdkservice.rbmarche.service.SetService;

@RestController
public class SetController {
	
	@Autowired
	private SetService setService;
	
	@RequestMapping("/Set")
	public Plan getInfoPieceByPlanName() {
		List<Plan> list = setService.getAllPlans();
		if(list != null && list.size() > 0) {
			Plan plan = list.get(0);
			return plan;
		}
		return null;
	}
	
	@RequestMapping(value = "/ShelveType", method = RequestMethod.GET)
	public List<ShelveType> getShelveType() {
		return setService.getAllShelveTypes();
	}
	
	@RequestMapping(value = "/Plan", produces = "application/json", method = RequestMethod.POST)
	public Plan savePlan(@RequestBody PlanB plan) {
		Plan nPlan;
		if(plan == null || plan.getId() == null || plan.getId() == -1) {
			nPlan = new Plan();
			nPlan.setName(plan.getName());
		} else {
			nPlan = setService.getPlanById(plan.getId());
		}
		nPlan.setCreatedAt(new Date());		
		nPlan.setPathSize(plan.getPathSize());
		return setService.savePlan(nPlan);
	}
	
	@RequestMapping(value = "/Board", produces = "application/json", method = RequestMethod.POST)
	public void savePlan(@RequestBody ShelveB shelve) {
	}
	
	@RequestMapping(value = "/Line", produces = "application/json", method = RequestMethod.POST)
	public Line saveLine(@RequestBody LineB lineB) {
		Line line;
		if(lineB.getId() == null || lineB.getId() < 0) {
			line = new Line();
			line.setPlan(setService.getPlanById(lineB.getPlanB().getId()));
		} else {
			line = setService.getLineById(lineB.getId());
		}
		line.setCreatedAt(new Date());		
		line = setService.saveLine(line);
		return line;
	}
	
	@RequestMapping(value = "/Shelve", produces = "application/json", method = RequestMethod.POST)
	public Shelve saveShelve(@RequestBody ShelveB shelveB) {		
		Shelve shelve;
		List<BoardB> boardBs = shelveB.getBoardBs();;
		if(shelveB.getId() == null || shelveB.getId() < 0) {
			shelve = new Shelve();
			Line line = setService.getLineById(shelveB.getLineB().getId());
			shelve.setLine(line);			
		} else {
			shelve = setService.getShelveById(shelveB.getId());
			List<Board> boards_orig = shelve.getBoards();
			if(boards_orig != null) {
				for(Board bo:boards_orig) {
					setService.deleteBoard(bo);
				}
			}
		}
		shelve.setCreatedAt(new Date());
		if(shelveB.getShelveTypeB() != null && shelveB.getShelveTypeB().getId() != null) {
			ShelveType st =setService.getShelveTypeById(shelveB.getShelveTypeB().getId());
			if(st != null) {
				shelve.setShelveType(setService.getShelveTypeById(shelveB.getShelveTypeB().getId()));
			}
		}
		List<Board> blist = new ArrayList<Board>();
		if(boardBs != null) {
			for(BoardB boardB : boardBs) {
				Board board = new Board();
				board.setCreatedAt(new Date());
				board.setFace(boardB.getFace());
				board.setPosition(boardB.getPosition());
				board.setShelve(shelve);
				blist.add(board);
			}	
		}		
		shelve.setBoards(blist);
		shelve = setService.updateBoardsOfShelve(shelve);		
		
		return shelve;
	}
	
	@RequestMapping(value = "/Line/{id}", method = RequestMethod.DELETE)
	public Plan deleteLineById(@PathVariable("id") Long id) {
		setService.deleteLineById(id);
		List<Plan> list = setService.getAllPlans();
		if(list != null && list.size() > 0) {
			Plan plan = list.get(0);
			return plan;
		}
		return null;
	}
	
	@RequestMapping(value = "/Shelve/{id}", method = RequestMethod.DELETE)
	public Plan deleteShelveById(@PathVariable("id") Long id) {
		setService.deleteShelveById(id);
		List<Plan> list = setService.getAllPlans();
		if(list != null && list.size() > 0) {
			Plan plan = list.get(0);
			return plan;
		}
		return null;
	}

}
