package com.fdkservice.rbmarche.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Plan implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float pathSize;
    @JsonIgnore
    private Date createdAt;
    
    @OneToMany(mappedBy = "plan", fetch = FetchType.LAZY)
    private List<Line> lines = new ArrayList<Line>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPathSize() {
		return pathSize;
	}

	public void setPathSize(float pathSize) {
		this.pathSize = pathSize;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

}
