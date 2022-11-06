package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.Catalog;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.shared.GenericServiceAPI;

public interface ICatalogService extends GenericServiceAPI<Catalog, String> {

    Catalog getByGenre(String genre);
    Serie saveSerie(Serie serie);
    Movie saveMovie(Movie movie);
}
