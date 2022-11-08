package com.digitalmedia.movies.service;

import com.digitalmedia.movies.model.Movie;
import com.digitalmedia.movies.shared.GenericServiceAPI;

import java.util.List;

public interface IMovieService extends GenericServiceAPI<Movie, String> {

    Movie validateAndGetMovie(String imdbId);

    List<Movie> getMovies();

    Movie saveMovie(Movie movie);

    void deleteMovie(Movie movie);
}