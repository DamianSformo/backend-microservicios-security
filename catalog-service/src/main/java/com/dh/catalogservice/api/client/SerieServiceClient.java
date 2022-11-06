package com.dh.catalogservice.api.client;

import com.dh.catalogservice.domain.model.Serie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="serie-service")
public interface SerieServiceClient {

    @PostMapping("/series/save")
    ResponseEntity<Serie> save(@RequestBody Serie serie);

    @GetMapping("/series/{id}")
    ResponseEntity<Serie> findOne(@PathVariable String id);

    @GetMapping("/series")
    ResponseEntity<List<Serie>> findAll();

    @GetMapping("/series/genre/{genre}")
    ResponseEntity<List<Serie>> getSeriesByGenre(@PathVariable String genre);

    @DeleteMapping("/series/{id}")
    ResponseEntity<Void> delete(@PathVariable String id);

}
