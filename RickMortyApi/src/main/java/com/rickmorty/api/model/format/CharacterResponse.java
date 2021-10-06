package com.rickmorty.api.model.format;

import com.rickmorty.api.model.entity.Location;

public class CharacterResponse {

    private String name;
    private String species;
    private String gender;
	private String image;
	private Location location;

	public CharacterResponse(){
    	
    }

    public CharacterResponse(String name, String species, String gender, String image){
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.image = image;
        this.location = new Location(1l, "Earth", "Planet");
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
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
