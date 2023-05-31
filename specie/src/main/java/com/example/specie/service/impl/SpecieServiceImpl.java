package com.example.specie.service.impl;

import com.example.specie.service.AnimalClient;
import com.example.specie.service.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecieServiceImpl implements SpecieService {
    @Autowired
    private AnimalClient animalClient;
    @Override
    public String findAnimalBySpecie(String specie) {
        return animalClient.findAnimalBySpecie(specie);
    }

}
