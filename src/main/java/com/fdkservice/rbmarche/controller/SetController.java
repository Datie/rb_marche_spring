package com.fdkservice.rbmarche.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdkservice.rbmarche.entity.Plan;
import com.fdkservice.rbmarche.entity.ShelveType;
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
	
	@RequestMapping("/ShelveType")
	public List<ShelveType> getShelveType() {
		return setService.getAllShelveTypes();
	}

}
