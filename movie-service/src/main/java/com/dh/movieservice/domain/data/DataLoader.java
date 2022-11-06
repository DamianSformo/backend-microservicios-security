package com.dh.movieservice.domain.data;

import com.dh.movieservice.api.service.IMovieService;
import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.domain.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {

    private final IMovieService service;

    public DataLoader(IMovieService service) {
        this.service = service;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        var movie1 = new Movie();
        movie1.setName("pienso en el final");
        movie1.setGenre("terror");
        movie1.setUrlStream("url");

        var mDB1 = service.save(movie1);
        log.info(mDB1.toString());

        var movie2 = new Movie();
        movie2.setName("maligno");
        movie2.setGenre("terror");
        movie2.setUrlStream("url");

        var mDB2 = service.save(movie2);
        log.info(mDB2.toString());

        var movie3 = new Movie();
        movie3.setName("candyman");
        movie3.setGenre("terror");
        movie3.setUrlStream("url");

        var mDB3 = service.save(movie3);
        log.info(mDB3.toString());

        var movie4 = new Movie();
        movie4.setName("encanto");
        movie4.setGenre("animación");
        movie4.setUrlStream("url");

        var mDB4 = service.save(movie4);
        log.info(mDB4.toString());

        var movie5 = new Movie();
        movie5.setName("luca");
        movie5.setGenre("animación");
        movie5.setUrlStream("url");

        var mDB5 = service.save(movie5);
        log.info(mDB5.toString());

        var movie6 = new Movie();
        movie6.setName("avatar");
        movie6.setGenre("ciencia ficción");
        movie6.setUrlStream("url");

        var mDB6 = service.save(movie6);
        log.info(mDB6.toString());

    }

}
