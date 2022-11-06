package com.dh.catalogservice.api.client;

import com.dh.catalogservice.domain.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="movie-service")
public interface MovieServiceClient {

    @PostMapping("/movies/save")
    ResponseEntity<Movie> save(@RequestBody Movie movie);

    @GetMapping("/movies/{id}")
    ResponseEntity<Movie> findOne(@PathVariable String id);

    @GetMapping("/movies")
    ResponseEntity<List<Movie>> findAll();

    @GetMapping("/movies/genre/{genre}")
    ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre);

    @DeleteMapping("/movies/{id}")
    ResponseEntity<Void> delete(@PathVariable String id);

}

