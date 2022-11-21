package com.dh.movieservice.domain.dto.response;

import lombok.Data;

@Data
public class CommentResponseDto {

    private Long id;

    private String username;

    private String text;
}
