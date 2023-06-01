package com.example.catalog.service.impl;

import com.example.catalog.service.CatalogService;
import com.example.catalog.service.MovieClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private MovieClient movieClient;

    @Override
    public List<?> findListMovieByGenre(String genre) {
        List<?> elements = movieClient.findListMovieByGenre(genre);
        return elements;
    }

    @Override
    public List<String> findMovieByGenre() {
        return movieClient.findMovieByGenre();
    }

}
