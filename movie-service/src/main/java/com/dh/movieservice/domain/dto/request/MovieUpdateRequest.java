package com.dh.movieservice.domain.dto.request;

import lombok.Data;

@Data
public class MovieUpdateRequest {

    private String title;

    private String director;

    private String yearPremiere;

    private String poster;
}