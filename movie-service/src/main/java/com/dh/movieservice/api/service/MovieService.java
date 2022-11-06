package com.dh.movieservice.api.service;

import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.domain.repository.MovieRepository;
import com.dh.movieservice.queue.MovieSender;
import com.dh.movieservice.shared.GenericServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService extends GenericServiceImpl<Movie, Long> implements IMovieService{

    private final MovieRepository movieRepository;

    private final MovieSender sender;

    @Override
    public List<Movie> getByGenre(String genre) {
    return movieRepository.getByGenre(genre);
    }

    @Override
    public Movie save(Movie entity) {
        var movieDB = super.save(entity);
        sender.sendMovie(movieDB);
        return movieDB;
    }

    @Override
    public JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }
}
