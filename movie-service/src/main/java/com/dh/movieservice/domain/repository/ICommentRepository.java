package com.dh.movieservice.domain.repository;

import com.dh.movieservice.domain.model.Comment;
import com.dh.movieservice.domain.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.movie.imdbId = ?1")
    List<Comment> getByImdbId(Long imdbId);

}
