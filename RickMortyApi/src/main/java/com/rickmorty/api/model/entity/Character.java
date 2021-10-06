package com.rickmorty.api.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "CHARACTER")
public class Character{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    private String species;
    private String gender;
	private String image;
	@ManyToMany(targetEntity = Episode.class,cascade = CascadeType.ALL )
	private List<Episode> episodes;
	
	public Character(){
    	
    }

    public Character(String name, String species, String gender, String image){
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.image = image;
    }

	public void setId(long id) {
		this.id = id;
	}
    
    public long getId() {
        return id;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

    public List<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}
}
