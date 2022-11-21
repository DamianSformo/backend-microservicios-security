package com.dh.movieservice.api.service;

import com.dh.movieservice.domain.dto.request.CommentRequestDto;
import com.dh.movieservice.domain.dto.response.CommentMovieResponseDto;
import com.dh.movieservice.domain.dto.response.CommentResponseDto;
import com.dh.movieservice.domain.model.Comment;
import com.dh.movieservice.shared.GenericServiceAPI;

import java.util.List;

public interface ICommentService extends GenericServiceAPI<Comment, CommentResponseDto, CommentRequestDto, Long> {

    List<CommentMovieResponseDto> getCommentsByImdbId(Long imdbId);
}
