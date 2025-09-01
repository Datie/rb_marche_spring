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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Line implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JsonIgnore
    private Plan plan;
    
    public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	
	@JsonIgnore
	private Date createdAt;
    
    @OneToMany(mappedBy = "line",fetch = FetchType.LAZY)
	private List<Shelve> shelves = new ArrayList<Shelve>();
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public List<Shelve> getShelves() {
		return this.shelves;
	}

	public void setShelves(List<Shelve> shelves) {
		this.shelves = shelves;
	}

}
