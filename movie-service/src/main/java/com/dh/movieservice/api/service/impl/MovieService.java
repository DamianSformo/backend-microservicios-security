package com.dh.movieservice.api.service.impl;

import com.dh.movieservice.api.service.IMovieService;
import com.dh.movieservice.domain.dto.request.CommentAddRequestDto;
import com.dh.movieservice.domain.dto.request.CommentRequestDto;
import com.dh.movieservice.domain.dto.request.MovieRequestDto;
import com.dh.movieservice.domain.dto.request.MovieUpdateRequest;
import com.dh.movieservice.domain.dto.response.MovieResponseDetailDto;
import com.dh.movieservice.domain.dto.response.MovieResponseDto;
import com.dh.movieservice.domain.dto.response.MovieResponseShowDto;
import com.dh.movieservice.domain.mapper.IMapper;
import com.dh.movieservice.domain.mapper.MovieMapper;
import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.domain.repository.MovieRepository;
import com.dh.movieservice.exception.MovieNotFoundException;
import com.dh.movieservice.security.jwt.IJwtUtils;
import com.dh.movieservice.shared.GenericServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;

@AllArgsConstructor
@Slf4j
@Service
public class MovieService extends GenericServiceImpl<Movie, MovieResponseDto, MovieRequestDto, Long> implements IMovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    private final CommentService commentService;

    private final IJwtUtils jwtUtils;

    private final Base64.Decoder decoder = Base64.getUrlDecoder();

    @Override
    public List<MovieResponseShowDto> getAll() {
        log.info("Películas obtenidas correctamente");
        return movieMapper.entityListToShowDtoList(movieRepository.findAll());
    }

    @Override
    public MovieResponseDetailDto getById(Long imdbId) throws MovieNotFoundException {
        return movieMapper.entityToMovieResponseDetailDto(movieRepository.findById(imdbId).orElseThrow(() -> new MovieNotFoundException(imdbId)), commentService.getCommentsByImdbId(imdbId));
    }

    public MovieResponseDto save(MovieRequestDto movieRequestDto) {
        log.info("Película agregada correctamente");
        return super.save(movieRequestDto);
    }

    @Override
    public MovieResponseDetailDto saveComment(CommentAddRequestDto commentAddRequestDto, Long imdbId, HttpServletRequest req) {
        getById(imdbId);

        String token = jwtUtils.getJwt(req.getHeader("Authorization"));
        String[] chunks = token.split("\\.");

        String payload = new String(decoder.decode(chunks[1]));

        String[] claims = payload.split("preferred_username\":\"");
        String userName = claims[1].split("\"")[0];

        CommentRequestDto commentRequestDto = new CommentRequestDto();
        commentRequestDto.setUsername(userName);
        commentRequestDto.setText(commentAddRequestDto.getText());
        commentRequestDto.setMovieImdbId(imdbId);
        commentService.save(commentRequestDto);
        log.info("Comentario agregado correctamente");
        return getById(imdbId);
    }

    @Override
    public MovieResponseDetailDto updateMovie(Long imdbId, MovieUpdateRequest movieUpdateRequest) {
        getById(imdbId);
        MovieRequestDto movieRequestDto = movieMapper.movieUpdateRequestToMovieRequestDto(movieUpdateRequest);
        movieRequestDto.setImdbId(imdbId);
        save(movieRequestDto);
        log.info("Película actualizada correctamente");
        return getById(imdbId);
    }

    public void delete(Long imdbId) {
        getById(imdbId);
        super.delete(imdbId);
        log.info("Película eliminada correctamente");
    }

    @Override
    public JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }

    @Override
    public IMapper<Movie, MovieResponseDto, MovieRequestDto> getMapper() {
        return movieMapper;
    }
}
