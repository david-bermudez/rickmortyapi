package com.rickmorty.api.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "LOCATION")
public class Location {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String type;
	private String dimension;
	
	public Location() {
		super();
	}
	
	public Location(long id, String type, String dimension) {
		super();
		this.id = id;
		this.type = type;
		this.dimension = dimension;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}	
}
