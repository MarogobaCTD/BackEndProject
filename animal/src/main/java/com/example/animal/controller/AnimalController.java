package com.example.animal.controller;

import com.example.animal.entity.AnimalEntity;
import com.example.animal.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animal")
@CrossOrigin(origins = "*")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<AnimalEntity>> findAll(){
        try{
            List<AnimalEntity> list = animalService.findAnimalByAll();
            return ResponseEntity.ok(list);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{specie}")
    public ResponseEntity<String> findAnimalBySpecie(@PathVariable String specie){
        try{
            String list = animalService.findAnimalBySpecie(specie);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<AnimalEntity> findAnimalByNome(@PathVariable String name){
        try{
            AnimalEntity animal = animalService.findAnimalByName(name);
            return ResponseEntity.ok(animal);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity addAnimal (@RequestBody AnimalEntity animal){
        try{
            if (animal != null){
                Optional<AnimalEntity> novoAnimal = animalService.addMovie(animal);
                if (novoAnimal.isPresent()) return new ResponseEntity<>(novoAnimal, HttpStatus.CREATED);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return null;
    }

}
