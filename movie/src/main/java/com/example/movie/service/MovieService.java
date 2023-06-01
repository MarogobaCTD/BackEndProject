package com.example.movie.service;

import com.example.movie.entity.MovieEntity;
import com.example.movie.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private IMovieRepository movieRepository;

    @Autowired
    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieEntity> findMovieByAll(){
        List<MovieEntity> movieEntities;
        return movieEntities = movieRepository.findAll();
    }

    public List<String> findMovieByGenre(){
        List<MovieEntity> movieEntities;
        movieEntities = movieRepository.findAll();
        List<String> catalogs = new ArrayList<String>();
        for (MovieEntity m : movieEntities){
            if (!catalogs.contains(m.getGenre())){
                catalogs.add(m.getGenre());
            }
        }
        return catalogs;
    }

    public List<MovieEntity> findListMovieByGenre(String genre){
        List<MovieEntity> animalEntities;
        animalEntities = movieRepository.findListMovieByGenre(genre);
        return animalEntities;
    }

    public MovieEntity findMovieByName(String name){
        return movieRepository.findMovieByName(name).get();
    }

    public MovieEntity findMovieById(Integer id){
        return movieRepository.findMovieById(id).get();
    }

    public Optional<MovieEntity> addMovie(MovieEntity movieEntity) {
        if (movieEntity == null) {
            return Optional.of(null);
        } else {
            MovieEntity movie = movieRepository.saveAndFlush(
                    new MovieEntity(
                            null,
                            movieEntity.getName(),
                            movieEntity.getGenre(),
                            movieEntity.getUrl_Stream()
                    )
            );
            return Optional.of(movie);
        }
    }



}

