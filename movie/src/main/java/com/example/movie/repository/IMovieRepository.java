package com.example.movie.repository;

import com.example.movie.entity.MovieEntity;
import com.example.movie.service.MovieService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IMovieRepository extends JpaRepository<MovieEntity, Long> {

    List<MovieEntity> findListMovieByGenre(String genre);

    MovieEntity findMovieByGenre(String genre);

    Optional<MovieEntity> findMovieByName(String name);

    Optional<MovieEntity> findMovieById(Integer id);
}
