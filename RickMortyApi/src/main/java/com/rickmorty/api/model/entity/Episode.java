package com.rickmorty.api.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "EPISODE")
public class Episode{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
	@ManyToMany(targetEntity = com.rickmorty.api.model.entity.Character.class, mappedBy = "episodes", cascade = CascadeType.ALL)
	private List<com.rickmorty.api.model.entity.Character> characters;
	
	public Episode(){
    	
    }
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<com.rickmorty.api.model.entity.Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<com.rickmorty.api.model.entity.Character> characters) {
		this.characters = characters;
	}

    
}
