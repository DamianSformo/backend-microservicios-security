package com.dh.serieservice.api.controller;

import com.dh.serieservice.api.service.SerieService;
import com.dh.serieservice.domain.model.Serie;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @PostMapping("/save")
    public ResponseEntity<Serie> save(@RequestBody Serie serie) {
        if(serie.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(serieService.save(serie));
        else
            return ResponseEntity.ok().body(serieService.save(serie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Serie> findOne(@PathVariable String id){
        var serie = serieService.getOne(id);
        if (serie == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(serie);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Serie>> findAll(){
        return ResponseEntity.ok().body(serieService.getAll());
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Serie>> findSeriesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(serieService.getByGenre(genre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        var serie = serieService.getOne(id);
        if (serie == null) {
            return ResponseEntity.notFound().build();
        } else {
            serieService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
