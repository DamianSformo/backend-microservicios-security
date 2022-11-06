package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.domain.model.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog, String> {

    @Query()
    Catalog getByGenre(String genre);
}
