package com.dh.movieservice.api.service.impl;

import com.dh.movieservice.api.service.ICommentService;
import com.dh.movieservice.domain.dto.request.CommentRequestDto;
import com.dh.movieservice.domain.dto.request.MovieRequestDto;
import com.dh.movieservice.domain.dto.response.CommentMovieResponseDto;
import com.dh.movieservice.domain.dto.response.CommentResponseDto;
import com.dh.movieservice.domain.dto.response.MovieResponseDto;
import com.dh.movieservice.domain.mapper.CommentMapper;
import com.dh.movieservice.domain.mapper.IMapper;
import com.dh.movieservice.domain.model.Comment;
import com.dh.movieservice.domain.repository.ICommentRepository;
import com.dh.movieservice.shared.GenericServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class CommentService extends GenericServiceImpl<Comment, CommentResponseDto, CommentRequestDto, Long> implements ICommentService {

    private final ICommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    public List<CommentMovieResponseDto> getCommentsByImdbId(Long imdbId) {
        return commentMapper.entityListToCommentMovieResponseDtoList(commentRepository.getByImdbId(imdbId));
    }

    public CommentResponseDto save(CommentRequestDto commentRequestDto) {
        log.info("Comentario agregado correctamente");
        return super.save(commentRequestDto);
    }

    @Override
    public JpaRepository<Comment, Long> getRepository() {
        return commentRepository;
    }

    @Override
    public IMapper<Comment, CommentResponseDto, CommentRequestDto> getMapper() {
        return commentMapper;
    }

}
