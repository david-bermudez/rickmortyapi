package com.rickmorty.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rickmorty.api.model.entity.Character;
import com.rickmorty.api.repository.CharacterRepository;
import com.rickmorty.api.service.CharacterService;

@RestController
public class CharacterController {

    private CharacterService characterService;
    private CharacterRepository characterRepository;

    public CharacterController(CharacterService characterService, CharacterRepository characterRepository) {
        this.characterService = characterService;
        this.characterRepository = characterRepository;
    }

    @PostMapping("/character/create")
    public ResponseEntity<Object> createCharacter(@RequestBody Character character) {
        return  characterService.addCharacter(character);
    }
    @DeleteMapping("/character/delete/{id}")
    public ResponseEntity<Object> deleteCharacter(@PathVariable Long id) {
        return characterService.deleteCharacter(id);
    }
    @GetMapping("/character/details/{id}")
    public Character getCharacter(@PathVariable Long id) {
        if(characterRepository.findById(id).isPresent())
            return characterRepository.findById(id).get();
        else return null;
    }
    @GetMapping("/character/all")
    public List<Character> getCharacters() {
        return characterRepository.findAll();
    }
    @PutMapping("/character/update/{id}")
    public ResponseEntity<Object> updateCharacter(@PathVariable Long id, @RequestBody Character Character) {
        return characterService.updateCharacter(id, Character);
    }
    
}