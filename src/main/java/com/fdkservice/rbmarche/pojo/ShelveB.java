package com.fdkservice.rbmarche.pojo;

import java.util.List;

public class ShelveB {
	
    private Long id;
    private LineB lineB;
    private ShelveTypeB shelveTypeB;
    private List<BoardB> boardBs;
    
	public List<BoardB> getBoardBs() {
		return boardBs;
	}
	public void setBoardBs(List<BoardB> boardBs) {
		this.boardBs = boardBs;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LineB getLineB() {
		return lineB;
	}
	public void setLineB(LineB lineB) {
		this.lineB = lineB;
	}
	public ShelveTypeB getShelveTypeB() {
		return shelveTypeB;
	}
	public void setShelveTypeB(ShelveTypeB shelveTypeB) {
		this.shelveTypeB = shelveTypeB;
	}	

}