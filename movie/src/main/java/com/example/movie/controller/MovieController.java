package com.example.movie.controller;

import com.example.movie.entity.MovieEntity;
import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieEntity>> findAll(){
        try{
            List<MovieEntity> list = movieService.findMovieByAll();
            return ResponseEntity.ok(list);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/catalog")
    public ResponseEntity<List<String>> findMovieByGenre() {
        try {
            return ResponseEntity.ok(movieService.findMovieByGenre());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<MovieEntity>> findListMovieByGenre(@PathVariable String genre){
        try{
            List<MovieEntity> list = movieService.findListMovieByGenre(genre);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<MovieEntity> findMovieByName(@PathVariable String name){
        try{
            MovieEntity movie = movieService.findMovieByName(name);
            return ResponseEntity.ok(movie);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MovieEntity> findMovieById(@PathVariable Integer id){
        try{
            MovieEntity movie = movieService.findMovieById(id);
            return ResponseEntity.ok(movie);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity addMovie (@RequestBody MovieEntity movie){
        try{
            if (movie != null){
                Optional<MovieEntity> novoMovie = movieService.addMovie(movie);
                if (novoMovie.isPresent()) return new ResponseEntity<>(novoMovie, HttpStatus.CREATED);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return null;
    }

}
