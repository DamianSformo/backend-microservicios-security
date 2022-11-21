package com.dh.movieservice.domain.data;

import com.dh.movieservice.api.service.ICommentService;
import com.dh.movieservice.api.service.IMovieService;
import com.dh.movieservice.domain.dto.request.CommentRequestDto;
import com.dh.movieservice.domain.dto.request.MovieRequestDto;
import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.domain.repository.ICommentRepository;
import com.dh.movieservice.domain.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {

    private final IMovieService movieService;
    private final ICommentService commentService;

    public DataLoader(IMovieService movieService, ICommentService commentService) {
        this.movieService = movieService;
        this.commentService = commentService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        var movieRequestDto = new MovieRequestDto();
        movieRequestDto.setTitle("Resident Evil: Apocalypse");
        movieRequestDto.setDirector("Paul W.S. Anderson");
        movieRequestDto.setPoster("https://m.media-amazon.com/images/M/MV5BMTc1NTUxMzk0Nl5BMl5BanBnXkFtZTcwNDQ1MDIzMw@@._V1_SX300.jpg");
        movieRequestDto.setYearPremiere("2004");

        var mDB1 = movieService.save(movieRequestDto);
        log.info(mDB1.toString());

        var commentRequestDto = new CommentRequestDto();
        commentRequestDto.setUsername("client");
        commentRequestDto.setText("Very Good");
        commentRequestDto.setMovieImdbId(1L);

        var cDB1 = commentService.save(commentRequestDto);
        log.info(cDB1.toString());

    }
}
