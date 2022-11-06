package com.dh.catalogservice.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(collection = "catalogs")
public class Catalog implements Serializable {

    @Id
    private String id;

    private String genre;

    private List<Movie> movies;

    private List<Serie> series;

}
