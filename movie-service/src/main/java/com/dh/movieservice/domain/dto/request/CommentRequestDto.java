package com.dh.movieservice.domain.dto.request;

import lombok.Data;

@Data
public class CommentRequestDto {

    private String username;

    private String text;

    private Long movieImdbId;

}
