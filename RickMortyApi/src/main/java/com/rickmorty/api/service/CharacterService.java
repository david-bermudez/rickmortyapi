package com.rickmorty.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rickmorty.api.model.entity.Character;
import com.rickmorty.api.model.entity.Episode;
import com.rickmorty.api.repository.CharacterRepository;
import com.rickmorty.api.repository.EpisodeRepository;

@Service
public class CharacterService {

    private CharacterRepository characterRepository;
    private EpisodeRepository episodeRepository;

    public CharacterService(CharacterRepository CharacterRepository, EpisodeRepository episodeRepository) {
        this.characterRepository = CharacterRepository;
        this.episodeRepository = episodeRepository;
    }

    /** Create a new Character  */
    @Transactional
    public ResponseEntity<Object> addCharacter(Character character)  {

        Character newCharacter = new Character();
        newCharacter.setName(character.getName());
        newCharacter.setSpecies(character.getName());
        newCharacter.setGender(character.getGender());
        newCharacter.setImage(character.getImage());
        
        
        List<Character> CharacterList = new ArrayList<>();
        CharacterList.add(newCharacter);
        for(int i=0; i< character.getEpisodes().size(); i++){
            if(!episodeRepository.findByName(character.getEpisodes().get(i).getName()).isPresent()) {
                Episode newEpisode = character.getEpisodes().get(i);
                newEpisode.setCharacters(CharacterList);
                Episode savedepisode = episodeRepository.save(newEpisode);
                if(! episodeRepository.findById(savedepisode.getId()).isPresent())
                    return ResponseEntity.unprocessableEntity().body("Character Creation Failed");
            }
             else  return   ResponseEntity.unprocessableEntity().body("episode with email Id is already Present");
        }
        return ResponseEntity.ok("Successfully created Character");
    }


    /** Delete a specified Character given the id */
    public ResponseEntity<Object> deleteCharacter(Long id) {
        if(characterRepository.findById(id).isPresent()){
            characterRepository.deleteById(id);
            if(characterRepository.findById(id).isPresent()){
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
            } else return ResponseEntity.ok().body("Successfully deleted specified record");
        } else
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }


    /** Update a Character */
    public ResponseEntity<Object> updateCharacter(Long id, Character character) {
        if(characterRepository.findById(id).isPresent()){
            Character newCharacter = characterRepository.findById(id).get();
            newCharacter.setName(character.getName());
            newCharacter.setSpecies(character.getName());
            newCharacter.setGender(character.getGender());
            newCharacter.setImage(character.getImage());
            
            Character savedCharacter = characterRepository.save(newCharacter);
            if(characterRepository.findById(savedCharacter.getId()).isPresent())
                return ResponseEntity.accepted().body("Character saved successfully");
            else return ResponseEntity.badRequest().body("Failed to update Character");

        } else return ResponseEntity.unprocessableEntity().body("Specified Character not found");
    }
}