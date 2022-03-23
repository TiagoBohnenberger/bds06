package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

//    @Query(value = "SELECT m FROM Movie m JOIN FETCH m.genre genre " + // Pageable não funciona com JOIN FETCH
//            "WHERE m.id = :movieId " +
//            "AND genre = :genre " +
//            "ORDER BY m.title")
//    Page<Movie> findMovie(long movieId);

    @Query(value = "SELECT m FROM Movie m INNER JOIN m.genre gen " +
            "WHERE (COALESCE(:genre) IS NULL OR gen = :genre) " +
            "ORDER BY m.title")
    Page<Movie> findAllPaged(Genre genre, Pageable pageable);
}
