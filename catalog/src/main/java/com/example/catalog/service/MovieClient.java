package com.example.catalog.service;

import com.example.catalog.custom.CatalogCustom;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("MOVIE-SERVICE")
@LoadBalancerClient(name="MOVIE-SERVICE", configuration = CatalogCustom.class)
public interface MovieClient {

    @GetMapping("/movies/{genre}")
    List<?> findListMovieByGenre(@PathVariable String genre);

    @GetMapping("/movies/catalog")
    List<String> findMovieByGenre();
}
