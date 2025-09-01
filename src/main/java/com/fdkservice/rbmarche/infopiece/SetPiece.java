package com.fdkservice.rbmarche.infopiece;

import java.io.Serializable;

import com.fdkservice.rbmarche.entity.Plan;

public class SetPiece implements Serializable {
	
	private Plan plan;

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	
	

}
