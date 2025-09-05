package com.fdkservice.rbmarche.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fdkservice.rbmarche.entity.Line;
import com.fdkservice.rbmarche.entity.Plan;
import com.fdkservice.rbmarche.entity.ShelveType;
import com.fdkservice.rbmarche.service.SetService;

@RestController
public class SetController {
	
	@Autowired
	private SetService setService;
	
	private final String OK = "OK";
	
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
	public Plan savePlan(@RequestBody Plan plan) {
		Plan nPlan = new Plan();
		nPlan.setCreatedAt(new Date());
		nPlan.setName(plan.getName());
		nPlan.setPathSize(plan.getPathSize());
		return setService.savePlan(nPlan);
	}
	
	@RequestMapping(value = "/Line", produces = "application/json", method = RequestMethod.POST)
	public Plan saveLine(@RequestBody Line line) {
		List<Plan> list = setService.getAllPlans();
		Plan nPlan;
		if(list == null || list.size() == 0) {
			nPlan = new Plan();
			nPlan.setCreatedAt(new Date());
			nPlan.setName("TEST");//get from session, to be changed
			nPlan.setPathSize(2);
			setService.savePlan(nPlan);
		} else {
			nPlan = list.get(0);
		}
		
		if(line == null || line.getId() == null || line.getId() < 0) {
			line = new Line();
		}
		line.setPlan(nPlan);
		setService.saveLine(line);
		list = setService.getAllPlans();
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
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

}
