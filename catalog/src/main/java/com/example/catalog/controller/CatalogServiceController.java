package com.example.catalog.controller;

import com.example.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogServiceController {
    @Autowired
    private CatalogService catalogService;

    @GetMapping("/{genre}")
    public ResponseEntity<List<?>> findListMovieByCatalog(@PathVariable String genre) {
        return ResponseEntity.ok(catalogService.findListMovieByGenre(genre));
    }

    @GetMapping
    public ResponseEntity<List<String>> findMovieByCatalog(){
        return ResponseEntity.ok(catalogService.findMovieByGenre());
    }

}
