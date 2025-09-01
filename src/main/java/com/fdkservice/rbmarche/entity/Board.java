package com.fdkservice.rbmarche.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Board implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@JsonIgnore
	private Date createdAt;

	@ManyToOne
	@JsonIgnore
	private Shelve shelve;
	
	public Shelve getShelve() {
		return shelve;
	}
	public void setShelve(Shelve shelve) {
		this.shelve = shelve;
	}
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
	private String face;
	private int position;

}
