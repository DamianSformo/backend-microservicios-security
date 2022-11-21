package com.dh.movieservice.domain.dto.response;

import lombok.Data;

@Data
public class MovieResponseDto {

    private Long imdbId;

    private String title;

    private String director;

    private String yearPremiere;

    private String poster;

}
