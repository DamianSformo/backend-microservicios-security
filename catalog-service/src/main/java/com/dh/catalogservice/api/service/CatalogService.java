package com.dh.catalogservice.api.service;

import com.dh.catalogservice.api.client.MovieServiceClient;
import com.dh.catalogservice.api.client.SerieServiceClient;
import com.dh.catalogservice.domain.model.Catalog;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.domain.repository.CatalogRepository;
import com.dh.catalogservice.shared.GenericServiceImpl;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CatalogService extends GenericServiceImpl<Catalog, String> implements ICatalogService{

    private final CatalogRepository catalogRepository;

    private final MovieServiceClient movieServiceClient;
    private final SerieServiceClient serieServiceClient;

    private final MovieService movieService;
    private final SerieService serieService;

    @Override
    public Catalog getByGenre(String genre) {
        Catalog catalog = catalogRepository.getByGenre(genre);
        if(catalog != null){
            catalog.setMovies(movieService.getByGenre(genre));
            catalog.setSeries(serieService.getByGenre(genre));
            return catalog;
        } else {
            Catalog catalogNew = new Catalog();
            catalogNew.setGenre(genre);
            catalogRepository.save(catalogNew);
            catalogNew.setMovies(movieService.getByGenre(genre));
            catalogNew.setSeries(serieService.getByGenre(genre));
            return catalogNew;
        }
    }

    @Override
    public Catalog getOne(String id){
        Optional<Catalog> catalog = catalogRepository.findById(id);
        if(catalog.isPresent()){
            catalog.get().setMovies(movieService.getByGenre(catalog.get().getGenre()));
            catalog.get().setSeries(serieService.getByGenre(catalog.get().getGenre()));
        }
        return catalog.orElse(null);
    }

    @Override
    public List<Catalog> getAll(){
        List<Catalog> catalogs = catalogRepository.findAll();
        for(Catalog c : catalogs){
            c.setMovies(movieService.getByGenre(c.getGenre()));
            c.setSeries(serieService.getByGenre(c.getGenre()));
        }
        return catalogs;
    }

    @Override
    @CircuitBreaker(name="serie", fallbackMethod = "serieFallbackMethod")
    public Serie saveSerie(Serie serie){
        return serieServiceClient.save(serie).getBody();
    }

    public Serie serieFallbackMethod(CallNotPermittedException exception){
        Serie serie = new Serie();
        serie.setName("fallo");
        return serie;
    }

    @Override
    @CircuitBreaker(name="movie", fallbackMethod = "movieFallbackMethod")
    public Movie saveMovie(Movie movie){
        return movieServiceClient.save(movie).getBody();
    }

    public Movie movieFallbackMethod(CallNotPermittedException exception){
        Movie movie = new Movie();
        movie.setName("fallo");
        return movie;
    }

    @Override
    public MongoRepository<Catalog, String> getRepository() {
        return catalogRepository;
    }
}
