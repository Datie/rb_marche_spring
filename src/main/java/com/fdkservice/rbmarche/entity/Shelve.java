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
public class Shelve implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@JsonIgnore
	private Date createdAt;
	
	@ManyToOne
	@JsonIgnore
	private Line line;
	
	@ManyToOne
	private ShelveType shelveType;
	
	@OneToMany(mappedBy = "shelve", fetch = FetchType.LAZY)
	private List<Board> boards = new ArrayList<Board>();

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public ShelveType getShelveType() {
		return this.shelveType;
	}

	public void setShelveType(ShelveType shelveType) {
		this.shelveType = shelveType;
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

	public List<Board> getBoards() {
		return boards;
	}

	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}
}
