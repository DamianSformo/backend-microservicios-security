package com.dh.movieservice.domain.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
public class Movie {

    @Id
    @SequenceGenerator(name = "expenseSequence",sequenceName = "expenseSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenseSequence")
    private Long imdbId;

    private String title;

    private String director;

    private String yearPremiere;

    private String poster;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Comment> comments;

}
