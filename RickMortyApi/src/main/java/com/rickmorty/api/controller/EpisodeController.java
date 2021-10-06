package com.rickmorty.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rickmorty.api.model.entity.Episode;
import com.rickmorty.api.model.format.CharacterResponse;
import com.rickmorty.api.model.format.EpisodeResponse;
import com.rickmorty.api.repository.EpisodeRepository;
import com.rickmorty.api.service.EpisodeService;

@RestController
public class EpisodeController {

	private EpisodeService episodeService;
    private EpisodeRepository episodeRepository;
    
	public EpisodeController(EpisodeService episodeService, EpisodeRepository episodeRepository) {
        this.episodeService = episodeService;
        this.episodeRepository = episodeRepository;
    }
	
	@PostMapping("/episode/create")
	public ResponseEntity<Object> createEpisode(@RequestBody Episode episode) {
	    return episodeService.createEpisode(episode);
	}
	
	@GetMapping("/episode/customDetail/{id}")
	public EpisodeResponse getCustomDetail(@PathVariable Long id) {
	    if(episodeRepository.findById(id).isPresent()) {
	    	
	    	EpisodeResponse response = new EpisodeResponse();
	    	Episode episode = episodeRepository.findById(id).get();
	    	response.setEpisode(episode.getId());
	    	response.setEpisodeName(episode.getName());
	    	ArrayList<CharacterResponse> list = new ArrayList<CharacterResponse>(); 
	    	for (com.rickmorty.api.model.entity.Character character : episode.getCharacters()) {
	    		list.add(new CharacterResponse(character.getName(), character.getSpecies(), character.getGender(), character.getImage()));
	    	}
	    	response.setCharacters(list);
	    	
	    	return response;
	    }
	        
	    else return  null;
	}
	
	@GetMapping("/episode/details/{id}")
	public Episode getEpisode(@PathVariable Long id) {
	    if(episodeRepository.findById(id).isPresent())
	        return episodeRepository.findById(id).get();
	    else return  null;
	}
	
	@GetMapping("/episode/all")
	public List<Episode> getepisodes() {
	    return episodeRepository.findAll();
	
	}
	
	@PutMapping("/episode/update/{id}")
	public ResponseEntity<Object> updateepisode(@PathVariable Long id, @RequestBody Episode episode) {
	    return episodeService.updateEpisode(episode, id);
	}
	
	@DeleteMapping("episode/delete/{id}")
	
	public ResponseEntity<Object> deleteEpisode(@PathVariable Long id) {
	
	    return episodeService.deleteEpisode(id);
	
	}
}