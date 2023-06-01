package com.example.animal.repository;

import com.example.animal.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IAnimalRepository extends JpaRepository<AnimalEntity, Long> {

    String findAnimalBySpecie(String specie);
    Optional<AnimalEntity> findAnimalByName(String name);
    List<AnimalEntity> findListAnimalBySpecie(String specie);

}
