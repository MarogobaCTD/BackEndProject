package com.example.catalog.service;

import java.util.List;

public interface CatalogService {

    List<?> findListMovieByGenre(String genre);

    List<String> findMovieByGenre();
}
