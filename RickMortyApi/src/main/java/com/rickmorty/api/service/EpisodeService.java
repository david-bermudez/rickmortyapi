package com.rickmorty.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rickmorty.api.model.entity.Episode;
import com.rickmorty.api.repository.CharacterRepository;
import com.rickmorty.api.repository.EpisodeRepository;

@Service
public class EpisodeService {

    private CharacterRepository characterRepository;
    private EpisodeRepository episodeRepository;

    public EpisodeService(EpisodeRepository episodeRepository, CharacterRepository characterRepository) {
        this.episodeRepository = episodeRepository;
        this.characterRepository = characterRepository;
    }

    public ResponseEntity<Object> createEpisode(Episode model) {
    	Episode episode = new Episode();
        if (episodeRepository.findByName(model.getName()).isPresent()) {
            return ResponseEntity.badRequest().body("The Episode is already Present, Failed !!!!!!");
        } else {
        	episode.setName(model.getName());

        	Episode savedEpisode = episodeRepository.save(episode);
            if (episodeRepository.findById(savedEpisode.getId()).isPresent())
                return ResponseEntity.ok("Episode Created Successfully");
            else return ResponseEntity.unprocessableEntity().body("Failed Creating Episode!!!!!");
        }
    }

    @Transactional
    public ResponseEntity<Object> updateEpisode(Episode episode, Long id) {
        if(episodeRepository.findById(id).isPresent()) {
            Episode newEpisode = episodeRepository.findById(id).get();
            newEpisode.setName(episode.getName());
            Episode savedEpisode = episodeRepository.save(newEpisode);
            if(episodeRepository.findById(savedEpisode.getId()).isPresent())
                return  ResponseEntity.accepted().body("Episode updated successfully");
            else return ResponseEntity.unprocessableEntity().body("Failed updating !!!!");
        } else return ResponseEntity.unprocessableEntity().body("Cannot find !!!!!!!");
    }

    public ResponseEntity<Object> deleteEpisode(Long id) {
        if (episodeRepository.findById(id).isPresent()) {
        	episodeRepository.deleteById(id);
            if (episodeRepository.findById(id).isPresent())
                return ResponseEntity.unprocessableEntity().body("Failed to Delete !!!!");
            else return ResponseEntity.ok().body("Successfully deleted !!!!");
        } else return ResponseEntity.badRequest().body("Cannot find !!!!!");
    }
}