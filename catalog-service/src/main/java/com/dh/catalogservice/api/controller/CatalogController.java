package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.Catalog;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/save")
    public ResponseEntity<Catalog> save(@RequestBody Catalog catalog) {
        if(catalog.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(catalogService.save(catalog));
        else
            return ResponseEntity.ok().body(catalogService.save(catalog));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catalog> findOne(@PathVariable String id){
        var catalog = catalogService.getOne(id);
        if (catalog == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(catalog);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Catalog>> findAll(){
        return ResponseEntity.ok().body(catalogService.getAll());
    }

    @GetMapping("genre/{genre}")
    public ResponseEntity<Catalog> findCatalogByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(catalogService.getByGenre(genre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        var catalog = catalogService.getOne(id);
        if (catalog == null) {
            return ResponseEntity.notFound().build();
        } else {
            catalogService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping("/series")
    public ResponseEntity<Serie> save(@RequestBody Serie serie) {
        if(serie.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(catalogService.saveSerie(serie));
        else
            return ResponseEntity.ok().body(catalogService.saveSerie(serie));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> save(@RequestBody Movie movie) {
        if(movie.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(catalogService.saveMovie(movie));
        else
            return ResponseEntity.ok().body(catalogService.saveMovie(movie));
    }
}
