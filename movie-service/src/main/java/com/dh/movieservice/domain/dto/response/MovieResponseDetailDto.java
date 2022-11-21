package com.dh.movieservice.domain.dto.response;

import com.dh.movieservice.domain.model.Comment;
import lombok.Data;

import java.util.List;

@Data
public class MovieResponseDetailDto {

    private Long imdbId;

    private String title;

    private String director;

    private String yearPremiere;

    private String poster;

    List<CommentMovieResponseDto> comments;

}
