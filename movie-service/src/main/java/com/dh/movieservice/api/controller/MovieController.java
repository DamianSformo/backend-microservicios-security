package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.service.impl.MovieService;
import com.dh.movieservice.domain.dto.request.CommentAddRequestDto;
import com.dh.movieservice.domain.dto.request.MovieRequestDto;
import com.dh.movieservice.domain.dto.request.MovieUpdateRequest;
import com.dh.movieservice.domain.dto.response.MovieResponseDetailDto;
import com.dh.movieservice.domain.dto.response.MovieResponseDto;
import com.dh.movieservice.domain.dto.response.MovieResponseShowDto;
import com.dh.movieservice.domain.model.Comment;
import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.exception.MovieNotFoundException;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RefreshScope
@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public ResponseEntity<List<MovieResponseShowDto>> getAll() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<MovieResponseDto> save(@RequestBody MovieRequestDto movieRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.save(movieRequestDto));
    }

    @PostMapping("/save/{imdbId}/comment")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public ResponseEntity<MovieResponseDetailDto> saveComment(@PathVariable Long imdbId, @RequestBody CommentAddRequestDto commentAddRequestDto, HttpServletRequest req) {
        return ResponseEntity.ok().body(movieService.saveComment(commentAddRequestDto, imdbId, req));
    }

    @PutMapping("/{imdbId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<MovieResponseDetailDto> updateMovie(@PathVariable Long imdbId, @RequestBody MovieUpdateRequest movieUpdateRequest) {
        return ResponseEntity.ok().body(movieService.updateMovie(imdbId, movieUpdateRequest));
    }

    @DeleteMapping("/{imdbId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long imdbId) {
        movieService.delete(imdbId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
