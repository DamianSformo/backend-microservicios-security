package com.digitalmedia.movies.service;

import com.digitalmedia.movies.exception.MovieNotFoundException;
import com.digitalmedia.movies.model.Movie;
import com.digitalmedia.movies.repository.IMovieRepository;
import com.digitalmedia.movies.shared.GenericServiceImpl;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl extends GenericServiceImpl<Movie, String> implements IMovieService {

    private final IMovieRepository movieRepository;

    @Override
    public Movie validateAndGetMovie(String imdbId) {
        return movieRepository.findById(imdbId).orElseThrow(() -> new MovieNotFoundException(imdbId));
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }

    @Override
    public MongoRepository<Movie, String> getRepository() {
        return movieRepository;
    }
}