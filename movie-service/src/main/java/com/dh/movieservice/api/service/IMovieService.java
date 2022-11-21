package com.dh.movieservice.api.service;

import com.dh.movieservice.domain.dto.request.CommentAddRequestDto;
import com.dh.movieservice.domain.dto.request.MovieRequestDto;
import com.dh.movieservice.domain.dto.request.MovieUpdateRequest;
import com.dh.movieservice.domain.dto.response.MovieResponseDetailDto;
import com.dh.movieservice.domain.dto.response.MovieResponseDto;
import com.dh.movieservice.domain.dto.response.MovieResponseShowDto;
import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.shared.GenericServiceAPI;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IMovieService extends GenericServiceAPI<Movie, MovieResponseDto, MovieRequestDto, Long>  {

    List<MovieResponseShowDto> getAll();

    MovieResponseDetailDto getById(Long imdbId);

    MovieResponseDetailDto saveComment(CommentAddRequestDto commentAddRequestDto, Long imdbId, HttpServletRequest req);

    MovieResponseDetailDto updateMovie(Long imdbId, MovieUpdateRequest movieUpdateRequest);


}
