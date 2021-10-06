package com.rickmorty.api.model.format;

import java.util.List;

public class EpisodeResponse {
	Long episode;
	String episodeName;
	List<CharacterResponse> characters;
	
	public EpisodeResponse(Long episode, String episodeName, List<CharacterResponse> characters) {
		super();
		this.episode = episode;
		this.episodeName = episodeName;
		this.characters = characters;
	}
	
	public EpisodeResponse() {
		super();
	}

	public Long getEpisode() {
		return episode;
	}
	public void setEpisode(Long episode) {
		this.episode = episode;
	}
	public String getEpisodeName() {
		return episodeName;
	}
	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}
	public List<CharacterResponse> getCharacters() {
		return characters;
	}
	public void setCharacters(List<CharacterResponse> characters) {
		this.characters = characters;
	}

}
