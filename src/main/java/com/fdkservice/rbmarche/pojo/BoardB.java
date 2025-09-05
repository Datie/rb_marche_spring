package com.fdkservice.rbmarche.pojo;

public class BoardB {
	
    private Long id;
    private ShelveB shelveB;
    private String face;
    private int position;
    
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ShelveB getShelveB() {
		return shelveB;
	}
	public void setShelveB(ShelveB shelveB) {
		this.shelveB = shelveB;
	}

}