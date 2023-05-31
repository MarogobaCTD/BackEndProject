package com.example.specie.controller;

import com.example.specie.service.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/specie")
public class SpecieController {

    @Autowired
    private SpecieService specieService;

    @GetMapping("/animal/{specie}")
    public ResponseEntity<String> findAnimalBySpecie(@PathVariable String specie) {
        return ResponseEntity.ok(specieService.findAnimalBySpecie(specie));
    }
}
