package com.dh.movieservice.domain.dto.response;

import lombok.Data;

@Data
public class MovieResponseShowDto {

    private Long imdbId;

    private String title;

    private String director;

}
