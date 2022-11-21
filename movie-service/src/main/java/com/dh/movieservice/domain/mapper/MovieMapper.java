package com.dh.movieservice.domain.mapper;

import com.dh.movieservice.domain.dto.request.MovieRequestDto;
import com.dh.movieservice.domain.dto.request.MovieUpdateRequest;
import com.dh.movieservice.domain.dto.response.CommentMovieResponseDto;
import com.dh.movieservice.domain.dto.response.MovieResponseDetailDto;
import com.dh.movieservice.domain.dto.response.MovieResponseDto;
import com.dh.movieservice.domain.dto.response.MovieResponseShowDto;
import com.dh.movieservice.domain.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class MovieMapper implements IMapper<Movie, MovieResponseDto, MovieRequestDto> {

    public abstract List<MovieResponseShowDto> entityListToShowDtoList(List<Movie> movieList);

    @Mapping(source = "commentList", target = "comments")
    public abstract MovieResponseDetailDto entityToMovieResponseDetailDto(Movie movie, List<CommentMovieResponseDto> commentList);

    public abstract MovieRequestDto movieUpdateRequestToMovieRequestDto(MovieUpdateRequest movieUpdateRequest);
}
