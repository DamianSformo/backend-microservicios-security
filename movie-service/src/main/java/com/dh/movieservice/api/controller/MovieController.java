package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.domain.model.Movie;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/save")
    public ResponseEntity<Movie> save(@RequestBody Movie movie) {
        if(movie.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(movieService.save(movie));
        else
            return ResponseEntity.ok().body(movieService.save(movie));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public ResponseEntity<Movie> findOne(@PathVariable Long id){
        var movie = movieService.getOne(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(movie);
        }
    }

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_manage-account')")
    public ResponseEntity<List<Movie>> findAll(){
        return ResponseEntity.ok().body(movieService.getAll());
    }

    @GetMapping("genre/{genre}")
    public ResponseEntity<List<Movie>> findMoviesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(movieService.getByGenre(genre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        var movie = movieService.getOne(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        } else {
            movieService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
