package com.dh.movieservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
public class Comment {

    @Id
    @SequenceGenerator(name = "commentSequence",sequenceName = "commentSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentSequence")
    private Long id;

    private String username;

    private String avatar;

    private String text;

    @ManyToOne()
    @JoinColumn(name = "movie_imdbId", referencedColumnName = "imdbId", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Movie movie;

    @CreationTimestamp
    private LocalDateTime timestamp;
}
