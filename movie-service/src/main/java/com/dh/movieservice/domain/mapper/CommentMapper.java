package com.dh.movieservice.domain.mapper;

import com.dh.movieservice.domain.dto.request.CommentRequestDto;
import com.dh.movieservice.domain.dto.response.CommentMovieResponseDto;
import com.dh.movieservice.domain.dto.response.CommentResponseDto;
import com.dh.movieservice.domain.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CommentMapper implements IMapper<Comment, CommentResponseDto, CommentRequestDto> {

    @Mapping(source = "movieImdbId", target = "movie.imdbId")
    public abstract Comment requestDtoToEntity(CommentRequestDto commentRequestDto);

    public abstract List<CommentMovieResponseDto> entityListToCommentMovieResponseDtoList(List<Comment> commentList);

}
