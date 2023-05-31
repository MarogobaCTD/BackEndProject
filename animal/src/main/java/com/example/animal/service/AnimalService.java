package com.example.animal.service;

import com.example.animal.entity.AnimalEntity;
import com.example.animal.repository.IAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private IAnimalRepository animalRepository;

    @Autowired
    public AnimalService(IAnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<AnimalEntity> findAnimalByAll(){
        List<AnimalEntity> animalEntities;
        return animalEntities = animalRepository.findAll();
    }

    public String findAnimalBySpecie(String specie){
        String animalEntities;
        animalEntities = animalRepository.findAnimalBySpecie(specie).toString();
        return animalEntities;
    }

    public AnimalEntity findAnimalByName(String name){
        return animalRepository.findAnimalByName(name).get();
    }

    public Optional<AnimalEntity> addMovie(AnimalEntity animalEntity) {
        if (animalEntity == null) {
            return Optional.of(null);
        } else {
            AnimalEntity animal = animalRepository.saveAndFlush(
                    new AnimalEntity(
                            null,
                            animalEntity.getName(),
                            animalEntity.getSpecie()
                    )
            );
            return Optional.of(animal);
        }
    }
}
